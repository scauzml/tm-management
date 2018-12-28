package com.springboot.mybatisplus.controller;


import com.springboot.mybatisplus.service.DsfUserService;
import com.springboot.mybatisplus.service.DsfUserTokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;

/**
 * 登录相关
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月10日 下午1:15:31
 */
@Api(tags = "登录相关")
@RestController
public class DsfLoginController extends BaseRestController {
    @Autowired
    private DsfUserService dsfUserService;
    @Autowired
    private DsfUserTokenService sysUserTokenService;
    @Autowired
    private DsfCaptchaService sysCaptchaService;
    @Autowired
    private DsfUserLoginLockService userLoginLockService;

    /**
     * 验证码
     */
    @GetMapping("/dsfcaptcha.jpg")
    @ApiOperation(value = "获取验证码", produces = "application/octet-stream")
    @ApiImplicitParam(name = "uuid", value = "UUID", defaultValue = "do1", dataType = "string", paramType = "query")
    public void captcha(HttpServletResponse response, String uuid) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //获取图片验证码
        BufferedImage image = sysCaptchaService.getCaptcha(uuid);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    /**
     * 登录
     */
    @SysLog(value = "系统登录日志", type = LogType.LOGIN)
    @PostMapping("/dsf/login")
    @ApiOperation(value = "用户登录")
    public DsfUserTokenEntity login(@RequestBody SysLoginForm form, HttpServletRequest request) {
        request.setAttribute("USER_NAME", form.getUsername());    //保存登录名

        //检查是否错误次数过多
        userLoginLockService.checkFailTimes(form.getUsername());

        boolean captcha = sysCaptchaService.validate(form.getUuid(), form.getCaptcha());
        if (!captcha) {
            throw new RestException(LoginError.DSF_LOGIN, "验证码不正确");
        }

        //用户信息
        DsfUserEntity user = dsfUserService.queryByUserName(form.getUsername());


        //帐号不存在、密码错误
        if (user == null || !user.getPassword().equals(new Sha256Hash(form.getPassword(), user.getSalt()).toHex())) {
            if (user != null) {   //若用户存在
                userLoginLockService.addFailTimes(form.getUsername());   //累计错误次数
            }
            throw new RestException(LoginError.DSF_LOGIN, "帐号或密码不正确,请重新输入");
        } else {
            userLoginLockService.clearFailTimes(form.getUsername());    //清空错误次数
        }
        request.setAttribute("USER_ID", user.getUserId());    //保存用户ID

        //帐号锁定
        if ("0".equals(user.getStatus())) {
            throw new RestException(LoginError.DSF_LOGIN, "帐号已被锁定,请联系管理员");
        }

        //更新时间与ip
        user.setLastLoginIp(HttpContextUtils.getHttpServletRequest().getRemoteAddr());
        user.setLastLoginTime(new Date());
        dsfUserService.updateById(user);

        //生成token，并保存到数据库
        return sysUserTokenService.createToken(user.getUserId());
    }

    /**
     * 退出
     */
    @PostMapping("/dsf/logout")
    @ApiOperation(value = "退出登录")
    @SysLog(value = "退出登录", type = LogType.EXIT)
    public void logout() {
        sysUserTokenService.logout(ShiroUtils.getDsfUserId());
    }


    /**
     * 累计登录错误次数
     *
     * @param username
     */
    private void addLoginErrorTimes(String username) {

    }

    /**
     * 清除登录错误次数
     *
     * @param username
     */
    private void clearLoginErrorTimes(String username) {

    }

}

