package com.springboot.mybatisplus.controller;


import com.springboot.mybatisplus.entity.TbUser;
import com.springboot.mybatisplus.service.ITbTeacherBookOrderService;
import com.springboot.mybatisplus.service.TeacherBookOrderService;
import com.springboot.mybatisplus.vo.TeachbookOrderVo;
import io.swagger.annotations.Api;
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
 * 教师征订子单 前端控制器
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@RestController
@Api("教材征订|教师征订子单")
@RequestMapping("/system/tbTeacherBookOrder")
public class TeacherBookOrderController extends BaseController {


	@Autowired
	private TeacherBookOrderService teacherBookOrderService;

	@GetMapping("/a")
	/*  @RequiresPermissions("")*/
	@ApiOperation("查找征订表单列表")
	@ApiImplicitParams(
			@ApiImplicitParam(name = "page", value="页码", paramType = "query" ,required = true, defaultValue = "1"),
			@ApiImplicitParam(name = "limit", value="每页条数", paramType = "query",required = true, defaultValue = "10")
	)
	public PageObject<TeachbookOrderVo> getOrderListByPage(@ApiIgnore @RequestParam Map<String, Object> params){
		PageObject<TeachbookOrderVo> page = teacherBookOrderService.getTeachBookOrderPage(params);

		return page;
	}
	
	@PostMapping("/toInsert")
    @RequiresPermissions("")
    @ApiOperation("")
    @ApiImplicitParam(name = "", value = "",paramType="", required = true)
	public String toInsert() {
		return "";
	}

	@PostMapping("/insert")
    @RequiresPermissions("")
    @ApiOperation("")
    @ApiImplicitParam(name = "", value = "",paramType="", required = true)
	@ResponseBody
	public Object insert() {
		return "";
	}

	@PostMapping("/toUpdate")
    @RequiresPermissions("")
    @ApiOperation("")
    @ApiImplicitParam(name = "", value = "",paramType="", required = true)
	public String toUpdate(String id) {
		return "";
	}

	@PostMapping("/Update")
    @RequiresPermissions("")
    @ApiOperation("")
    @ApiImplicitParam(name = "", value = "",paramType="", required = true)
	@ResponseBody
	public Object update() {
		return "";
	}

	@PostMapping("/delete")
    @RequiresPermissions("")
    @ApiOperation("")
    @ApiImplicitParam(name = "", value = "",paramType="", required = true)
	@ResponseBody
	public Object delete() {
		return "";
	}
	

}

