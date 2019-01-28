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
 * 班级订购总单
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@TableName("tb_class_book_total_order")
@EqualsAndHashCode(callSuper = true)
public class TbClassBookTotalOrder extends BaseEntity<TbClassBookTotalOrder> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableField("user_id")
    private String userId;
    /**
     * 批次id
     */
    @TableField("batch_id")
    private String batchId;
    /**
     * 总金额
     */
    @TableField("totalmoney")
    private String totalmoney;
    /**
     * 总的订书量
     */
    @TableField("totalnum")
    private Integer totalnum;
    /**
     * 支付状态（0 未完成支付 1 已完成支付）
     */
    @TableField("state_pay")
    private Integer statePay;

}
