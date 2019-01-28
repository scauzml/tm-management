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
 * 计划
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Data
@TableName("tb_plan")
@EqualsAndHashCode(callSuper = true)
public class TbPlan extends BaseEntity<TbPlan> {

    private static final long serialVersionUID = 1L;

    /**
     * 计划id
     */
    @TableField("batch_id")
    private String batchId;
    /**
     * 计划名称
     */
    @TableField("plan_name")
    private String planName;


}
