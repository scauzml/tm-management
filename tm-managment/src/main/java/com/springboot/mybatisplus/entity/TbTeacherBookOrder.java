package com.springboot.mybatisplus.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * <p>
 * 教师征订子单
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Data
@TableName("tb_teacher_book_order")
@EqualsAndHashCode(callSuper = true)
public class TbTeacherBookOrder extends BaseEntity<TbTeacherBookOrder> {

    private static final long serialVersionUID = 1L;

    /**
     * 教师总征订订单id
     */
    @TableField("teacher_book_total_order_id")
    private String teacherBookTotalOrderId;
    /**
     * 教材id
     */
    @TableField("teachbook_id")
    private String teachbookId;
    /**
     * 课程
     */
    @TableField("course")
    private String course;
    /**
     * 审批状态
     */
    @TableField("state_check")
    private Integer stateCheck;
    /**
     * 提交状态，征订状态
     */
    @TableField("state_booking")
    private Integer stateBooking;
    /**
     * 征订数量
     */
    @TableField("num")
    private String num;
    /**
     * 征订批次id
     */
    @TableField("bathid")
    private String bathid;
    /**
     * 教师征订总单id
     */
    @TableField("total_order_id")
    private String totalOrderId;
    /**
     * 计划审批状态（0 未审批，1 已审批，2 已退回）
     */
    @TableField("state_plan_check")
    private Integer statePlanCheck;
    /**
     * 是否是学院必须教材（0 否，1 是）
     */
    @TableField("is_need")
    private Integer isNeed;

}
