package com.springboot.mybatisplus.controller;


import com.springboot.mybatisplus.entity.TbAcademy;
import com.springboot.mybatisplus.entity.TbUser;
import com.springboot.mybatisplus.service.ITbUserService;
import com.springboot.mybatisplus.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Controller
@RequestMapping("/system/tbUser")
public class UserController extends BaseController {


	@Autowired
	private UserService userService;

	@GetMapping("/a")
	/*  @RequiresPermissions("")*/
	@ApiOperation("查找学生列表")
	@ApiImplicitParams(
			@ApiImplicitParam(name = "page", value="页码", paramType = "query" ,required = true, defaultValue = "1"),
			@ApiImplicitParam(name = "limit", value="每页条数", paramType = "query",required = true, defaultValue = "10")
	)
	public PageObject<TbUser> getOrderListByPage(@ApiIgnore @RequestParam Map<String, Object> params){
		PageObject<TbUser> page = userService.getStudentPage(params);

		return page;
	}

	@GetMapping("/a")
	/*  @RequiresPermissions("")*/
	@ApiOperation("查找其他用户列表")
	@ApiImplicitParams(
			@ApiImplicitParam(name = "page", value="页码", paramType = "query" ,required = true, defaultValue = "1"),
			@ApiImplicitParam(name = "limit", value="每页条数", paramType = "query",required = true, defaultValue = "10")
	)
	public PageObject<TbUser> getOrderListByPage(@ApiIgnore @RequestParam Map<String, Object> params){
		PageObject<TbUser> page = userService.getOtherUserPage(params);

		return page;
	}
	@PostMapping("/toInsert")
	/*@RequiresPermissions("")*/
	@ApiOperation("增加用户")

	public void toInsert(@RequestBody TbUser tbUser) {

		userService.save(tbUser);
	}

	@PostMapping("/toUpdate")
	/* @RequiresPermissions("")*/
	@ApiOperation("更新用户和更新密码")
	@ApiImplicitParam(name = "", value = "",paramType="", required = true)
	public void update(@RequestBody TbUser tbUser) {

		userService.update(tbUser);
	}


	@PostMapping("/delete")
	/* @RequiresPermissions("")*/
	@ApiOperation("逻辑删除")

	@ResponseBody
	public void delete(@RequestBody TbUser tbUser) {

		userService.delete(tbUser);
	}


	@GetMapping("/getinformation/{id}")
	/* @RequiresPermissions("")*/
	@ApiOperation("获取个人信息")

	@ResponseBody
	public void getInformation(@PathVariable("id") String id) {

		userService.selectUserByid(id);
	}

	@GetMapping("/isExitUser")
	/* @RequiresPermissions("")*/
	@ApiOperation("是否存在当前账号email")
	@ApiImplicitParam(name = "email", value="邮箱", paramType = "query" ,required = true, defaultValue = "13828607279@163.com")
	@ResponseBody
	public boolean isExitUser(@ApiIgnore @RequestParam Map<String, Object> params) {
		String email =(String)params.get("email");
		userService.selectUserByid(email);
	}
}

