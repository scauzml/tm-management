package com.springboot.mybatisplus.controller;


import com.springboot.mybatisplus.entity.TbClass;
import com.springboot.mybatisplus.service.ClassService;
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
 * 班级 前端控制器
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Controller
@RequestMapping("/system/tbClass")
public class ClassController extends BaseController {


	@Autowired
	private ClassService classService;

    @GetMapping("/a")
    /*  @RequiresPermissions("")*/
    @ApiOperation("查找班级列表")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "page", value="页码", paramType = "query" ,required = true, defaultValue = "1"),
            @ApiImplicitParam(name = "limit", value="每页条数", paramType = "query",required = true, defaultValue = "10")
    )
    public PageObject<TbClass> getOrderListByPage(@ApiIgnore @RequestParam Map<String, Object> params){
        PageObject<TbClass> page = classService.getClassPage(params);

        return page;
    }

    @PostMapping("/toInsert")
    /*@RequiresPermissions("")*/
    @ApiOperation("增加班级")

    public void toInsert(@RequestBody TbClass tbClass) {

        classService.save(tbClass);
    }

    @PostMapping("/toUpdate")
    /* @RequiresPermissions("")*/
    @ApiOperation("更新")
    @ApiImplicitParam(name = "", value = "",paramType="", required = true)
    public void update(@RequestBody TbClass tbClass) {

        classService.update(tbClass);
    }


    @PostMapping("/delete")
    /* @RequiresPermissions("")*/
    @ApiOperation("逻辑删除")

    @ResponseBody
    public void delete(@RequestBody TbClass tbClass) {

        classService.delete(tbClass);
    }

}

