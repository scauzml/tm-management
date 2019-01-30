package com.springboot.mybatisplus.controller;


import com.springboot.mybatisplus.entity.TbAcademy;
import com.springboot.mybatisplus.service.AcademyService;
import com.springboot.mybatisplus.service.ITbAcademyService;
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
 * 学院 前端控制器
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Controller
@RequestMapping("/system/tbAcademy")
public class AcademyController extends BaseController {


	@Autowired
	private AcademyService academyService;
	
	@GetMapping("/a")
  /*  @RequiresPermissions("")*/
    @ApiOperation("查找学院列表")
    @ApiImplicitParams(
			@ApiImplicitParam(name = "page", value="页码", paramType = "query" ,required = true, defaultValue = "1"),
			@ApiImplicitParam(name = "limit", value="每页条数", paramType = "query",required = true, defaultValue = "10")
	)
	public PageObject<TbAcademy> getOrderListByPage(@ApiIgnore @RequestParam Map<String, Object> params){
		PageObject<TbAcademy> page = academyService.getTbAcademyPage(params);

		return page;
	}
	
	@PostMapping("/toInsert")
    /*@RequiresPermissions("")*/
    @ApiOperation("增加学院")

	public void toInsert(@RequestBody TbAcademy tbAcademy) {

    	academyService.save(tbAcademy);
	}

	@PostMapping("/toUpdate")
   /* @RequiresPermissions("")*/
    @ApiOperation("")
    @ApiImplicitParam(name = "", value = "",paramType="", required = true)
	public void update(@RequestBody TbAcademy tbAcademy) {

		academyService.update(tbAcademy);
	}


	@PostMapping("/delete")
   /* @RequiresPermissions("")*/
    @ApiOperation("逻辑删除")

	@ResponseBody
	public void delete(@RequestBody TbAcademy tbAcademy) {

		academyService.delete(tbAcademy);
	}
	

}

