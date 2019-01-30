package com.springboot.mybatisplus.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author{张明亮} 2019/1/29 10:22
 */
@ApiModel("返回信息")
@Data
public class CommonVo<T> {
    @ApiModelProperty(value="是否成功true,false",example = "true")
    private boolean isSuccess;
    @ApiModelProperty(value="返回的vo")
    private T responseVo;
}
