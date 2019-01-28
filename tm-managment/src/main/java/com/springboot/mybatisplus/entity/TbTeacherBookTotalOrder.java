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
 * 教师征订总表单
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Data
@TableName("tb_teacher_book_total_order")
@EqualsAndHashCode(callSuper = true)
public class TbTeacherBookTotalOrder extends BaseEntity<TbTeacherBookTotalOrder> {

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
     * 计划id
     */
    @TableField("plan_id")
    private String planId;


}
