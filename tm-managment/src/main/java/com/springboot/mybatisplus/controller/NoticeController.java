package com.springboot.mybatisplus.controller;


import com.springboot.mybatisplus.entity.TbClass;
import com.springboot.mybatisplus.entity.TbNotice;
import com.springboot.mybatisplus.service.NoticeService;
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
 * 公告 前端控制器
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Controller
@RequestMapping("/system/tbNotice")
public class NoticeController extends BaseController {


	@Autowired
	private NoticeService noticeService;

	@GetMapping("/list")
	/*  @RequiresPermissions("")*/
	@ApiOperation("查找公告列表")
	@ApiImplicitParams(
			@ApiImplicitParam(name = "page", value="页码", paramType = "query" ,required = true, defaultValue = "1"),
			@ApiImplicitParam(name = "limit", value="每页条数", paramType = "query",required = true, defaultValue = "10")
	)
	public PageObject<TbNotice> getOrderListByPage(@ApiIgnore @RequestParam Map<String, Object> params){
		PageObject<TbNotice> page = noticeService.getNoticePage(params);

		return page;
	}

	@PostMapping("/toInsert")
	/*@RequiresPermissions("")*/
	@ApiOperation("增加公告")

	public void toInsert(@RequestBody TbNotice tbNotice) {

		noticeService.save(tbNotice);
	}

	@PostMapping("/toUpdate")
	/* @RequiresPermissions("")*/
	@ApiOperation("更新")
	@ApiImplicitParam(name = "", value = "",paramType="", required = true)
	public void update(@RequestBody TbNotice tbNotice) {

		noticeService.update(tbNotice);
	}


	@PostMapping("/delete")
	/* @RequiresPermissions("")*/
	@ApiOperation("逻辑删除")

	@ResponseBody
	public void delete(@RequestBody TbNotice tbNotice) {

		noticeService.delete(tbNotice);
	}

}

