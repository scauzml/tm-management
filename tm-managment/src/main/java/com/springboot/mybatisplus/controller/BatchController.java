package com.springboot.mybatisplus.controller;


import com.springboot.mybatisplus.entity.TbBatch;
import com.springboot.mybatisplus.service.BatchService;
import com.springboot.mybatisplus.util.PageObject;
import com.springboot.mybatisplus.vo.CommonVo;
import com.springboot.mybatisplus.vo.systemvo.BatchVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.formula.functions.T;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

/**
 * <p>
 * 批次 前端控制器
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Api(tags = "系统设置|征订批次设置（张明亮）")
@RestController
@RequestMapping("/system/batch")
public class BatchController extends BaseController {


	@Autowired
	private BatchService batchService;
	
	@GetMapping("/batchlist")
   /* @RequiresPermissions("")*/
    @ApiOperation("查询征订批次列表")
    @ApiImplicitParams({
			@ApiImplicitParam(name = "page", value="页码", paramType = "query" ,required = true, defaultValue = "1"),
			@ApiImplicitParam(name = "limit", value="每页条数", paramType = "query",required = true, defaultValue = "10")
	})
	public PageObject<BatchVo> list(@ApiIgnore @RequestParam Map<String, Object> params) {
        PageObject<BatchVo> page =batchService.getBatchPage(params);
		return page;
	}



	@PostMapping("/toInsert")
   /* @RequiresPermissions("")*/
    @ApiOperation("保存批次")
	public void toInsert(@RequestBody TbBatch tbBatch) {

        batchService.save(tbBatch);

	}

	@PostMapping("/toupdate")
	/* @RequiresPermissions("")*/
	@ApiOperation("更新批次")
	public void toupdate(@RequestBody TbBatch tbBatch) {

		batchService.update(tbBatch);

	}

	@PostMapping("/todelete")
	/* @RequiresPermissions("")*/
	@ApiOperation("删除批次")
	public void todelete(@RequestBody TbBatch tbBatch) {

		batchService.delete(tbBatch);

	}



}

