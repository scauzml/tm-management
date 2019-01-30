package com.springboot.mybatisplus.vo.systemvo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author{张明亮} 2019/1/29 14:28
 */
@Data
@ApiModel("批次")
public class BatchVo {

    @ApiModelProperty(value="批次id",example = "1111")
    private String id;
    @ApiModelProperty(value="批次名字",example = "2019年春季批次")
    private String batchName;
    @ApiModelProperty(value="开始填写征订表单时间",example = "2019-01-29")
    private Date startWriteTime;
    @ApiModelProperty(value="结束填写征订表单的时间",example = "2019-01-29")
    private Date endWriteTime;
    @ApiModelProperty(value="开始预订时间",example = "2019-01-29")
    private Date startBookingTime;
    @ApiModelProperty(value="结束预订时间",example = "2019-01-29")
    private Date endBookingTime;
    @ApiModelProperty(value="创建时间",example = "2019-01-29")
    private Date createTime;
    @ApiModelProperty(value="折扣",example = "0.8")
    private String discount;


}
