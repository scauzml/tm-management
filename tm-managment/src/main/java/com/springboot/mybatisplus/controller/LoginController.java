package com.springboot.mybatisplus.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author zhangmingliang
 * @date 2018-12-27 10:17
 */

@Api(tags = "构建项目测试，登录,注册,api")
@RestController
public class LoginController {
    @GetMapping(value = "/login")
    @ApiOperation("进入登录页面")

    public String login() {
        return "logain";
    }


    @PostMapping(value = "/user")
    @ApiOperation("测试用户")
    public String login(@RequestParam String username, @RequestParam String password, Model model){

        try {
            model.addAttribute("username", username);
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
            Subject subject = SecurityUtils.getSubject();
            //完成登录
            subject.login(usernamePasswordToken);
            return "redirect:/index";
        } catch (Exception e) {
            String ex = e.getClass().getName();
            if (ex != null) {
                if (UnknownAccountException.class.getName().equals(ex)) {
                    System.out.println("用户名不存在");
                } else if (IncorrectCredentialsException.class.getName().equals(ex)) {
                    System.out.println("账户或密码错误");
                } else {
                    System.out.println("未知错误");
                }
            }
            //返回登录页面
            return "logwin";
        }
    }


    @GetMapping(value = "/index")
    @ApiOperation(value="测试index")
    public String index(){
        return "welcome";
    }


    @RequestMapping("/logout")
    @ApiOperation("登出")
    public String logOut(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login";
    }



    //未授权mapping配置

    @GetMapping(value = "/403")
    @ApiOperation("没有权限")

    public String error(){
        return "没有权限!";
    }


    //注解的使用
    //管理员角色

    @RequiresRoles("admin")
    @RequestMapping(value = "/role/admin")
    @ApiOperation("测试角色admin")

    public String roleAdmin(){
        return "I am admin";
    }

    //普通用户角色
    @ResponseBody
    @RequiresRoles("common")
    @RequestMapping(value = "/role/common")
    @ApiOperation(value = "测试角色common")
    public String roleCommon(){
        return "I am common";
    }

    //拥有添加、删除权限

    @RequiresPermissions({"add","delete"})
    @RequestMapping(value = "/permissions")
    @ApiOperation("测试角色权限add,delete")
    public String Permissions(){
        return "I have permissions add and delete";
    }

    //只拥有添加权限

    @RequiresPermissions("add")
    @RequestMapping(value = "/permission/add")
    @ApiOperation("测试权限add")
    public String Permission(){
        return "I have permission add";
    }

}
