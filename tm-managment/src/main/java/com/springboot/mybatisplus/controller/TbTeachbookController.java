package com.springboot.mybatisplus.controller;


import com.springboot.mybatisplus.service.ITbTeachbookService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 教材 前端控制器
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Controller
@RequestMapping("/system/tbTeachbook")
public class TbTeachbookController extends BaseController {


	@Autowired
	private ITbTeachbookService iTbTeachbookService;
	
	@GetMapping("/a")
    @RequiresPermissions("")
    @ApiOperation("")
    @ApiImplicitParam(name = "", value = "",paramType="", required = true)
	public String list() {
		
		return "";
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

