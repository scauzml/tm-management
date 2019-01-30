package com.springboot.mybatisplus.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * <p>
 * 批次
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Data
@ApiModel(description = "批次实体")
@TableName("tb_batch")
@EqualsAndHashCode(callSuper = true)
public class TbBatch extends BaseEntity<TbBatch> {

    private static final long serialVersionUID = 1L;


    /**
     * 批次名字
     */
    @ApiModelProperty(value = "批次名字", example = "2019年春季批次")
    @TableField("batch_name")
    private String batchName;
    /**
     * 开始填写征订表单时间
     */
    @ApiModelProperty(value = "开始填写征订表单时间", example = "2019-01-29")
    @TableField("start_write_time")
    private Date startWriteTime;
    /**
     * 结束填写征订表单的时间
     */
    @ApiModelProperty(value = "结束填写征订表单的时间", example = "2019-01-29")
    @TableField("end_write_time")
    private Date endWriteTime;
    /**
     * 开始预订时间
     */
    @ApiModelProperty(value = "开始预订时间", example = "2019-01-29")
    @TableField("start_booking_time")
    private Date startBookingTime;
    /**
     * 结束预订时间
     */
    @ApiModelProperty(value = "结束预订时间", example = "2019-01-29")
    @TableField("end_booking_time")
    private Date endBookingTime;

    /**
     * 折扣
     */
    @ApiModelProperty(value = "折扣", example = "0.8")
    @TableField("discount")
    private String discount;


}
