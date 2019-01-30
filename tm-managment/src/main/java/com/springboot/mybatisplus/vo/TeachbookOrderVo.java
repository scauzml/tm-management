package com.springboot.mybatisplus.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
/**
 * @author zhangmingliang
 * @date 2019-01-30 16:27
 */
@Data
@ApiModel("教材征订例子")
public class TeachbookOrderVo {
    @ApiModelProperty(value = "主键id", example = "3323")
    private String id;
    @ApiModelProperty(value = "创建时间", example = "2019-02-03")
    private Date createtime;
    /**
     * 教师总征订订单id
     */
    @ApiModelProperty(value = "征订总单id", example = "33434")
    private String teacherBookTotalOrderId;
    /**
     * 教材id
     */
    @ApiModelProperty(value = "教材id", example = "2323")
    private String teachbookId;
    @ApiModelProperty(value = "教材名字", example = "java开发")
    private String bookname;
    @ApiModelProperty(value = "征订教师", example = "张三")
    private String bookPeople;
    @ApiModelProperty(value = "教材作者", example = "张三，李四")
    private String actor;
    @ApiModelProperty(value = "定价", example = "59")
    private String price;
    @ApiModelProperty(value = "出版时间", example = "2019-02-03")
    private Date publisheddate;
    @ApiModelProperty(value = "出版社", example = "北京出版社")
    private String publishing;
    /**
     * 课程
     */
    @ApiModelProperty(value = "征订课程", example = "java基础开发")
    private String course;
    /**
     * 审批状态
     */
    @ApiModelProperty(value = "是否已审批，0 未审批，已审批", example = "0")
    private Integer stateCheck;
    @ApiModelProperty(value = "是否已审批，0 未审批，已审批", example = "未审批")
    private String stateCheckStr;
    /**
     * 提交状态，征订状态
     */
    @ApiModelProperty(value = "提交状态0 未提交，1 已提交，2 已退订", example = "0")
    private Integer stateBooking;
    @ApiModelProperty(value = "提交状态0 未提交，1 已提交，2 已退订", example = "未提交")
    private Integer stateBookingStr;
    /**
     * 征订数量
     */
    @ApiModelProperty(value = "征订数量", example = "0")
    private String num;
    /**
     * 征订批次id
     */
    @ApiModelProperty(value = "批次id", example = "3443")
    private String bathid;
    @ApiModelProperty(value = "批次名字", example = "2019春季批次")
    private String batchname;
    @ApiModelProperty(value = "批次时间", example = "2019-04-22")
    private Date batchtime;
    /**
     * 教师征订总单id
     */
    @ApiModelProperty(value = "教师征订总单id", example = "1111")
    private String totalOrderId;
    /**
     * 计划审批状态（0 未审批，1 已审批，2 已退回）
     */
    @ApiModelProperty(value = "计划审批状态（0 未审批，1 已审批，2 已退回）", example = "0")
    private Integer statePlanCheck;
    @ApiModelProperty(value = "计划审批状态（0 未审批，1 已审批，2 已退回）", example = "未审批")
    private String statePlanCheckStr;
    /**
     * 是否是学院必须教材（0 否，1 是）
     */
    @ApiModelProperty(value = "是否是学院必须教材（0 否，1 是）", example = "0")
    private Integer isNeed;
    @ApiModelProperty(value = "是否是学院必须教材（0 否，1 是）", example = "否")
    private String isNeedStr;

}
