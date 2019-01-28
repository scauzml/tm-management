package com.springboot.mybatisplus.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.EqualsAndHashCode;


/**
 * <p>
 * 班级订购子单
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@TableName("tb_class_book_order")
@EqualsAndHashCode(callSuper = true)
public class TbClassBookOrder extends BaseEntity<TbClassBookOrder> {

    private static final long serialVersionUID = 1L;

    /**
     * 教师征订单id
     */
    @TableField("teacher_book_order_id")
    private String teacherBookOrderId;
    /**
     * 班级订购总单id
     */
    @TableField("class_book_total_order_id")
    private String classBookTotalOrderId;
    /**
     * 订购数量
     */
    @TableField("bookingnum")
    private Integer bookingnum;
    /**
     * 领书状态（0 未领书 1 以领书 2 缺书）
     */
    @TableField("state_getbook")
    private Integer stateGetbook;
    /**
     * 订购金额
     */
    @TableField("total_money")
    private String totalMoney;
    /**
     * 付款状态（0 未付 1 已付）
     */
    @TableField("state_pay")
    private Integer statePay;


}
