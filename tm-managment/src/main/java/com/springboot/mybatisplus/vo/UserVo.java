package com.springboot.mybatisplus.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * @author{张明亮} 2018/12/22 17:07
 */
@Data
public class UserVo {
    @ApiParam("主键id")
    @TableId(value="id")
    private Long id;
    /**
     * TableField 的value可为空，驼峰命名方式自动识别
     */
    @ApiParam("姓名")
    @TableField(value="name")
    private String name;
    /**
     * TableField 的value可为空，驼峰命名方式自动识别
     */
    @ApiParam("密码")
    @TableField(value="password")
    private Integer password;
}
