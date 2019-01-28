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
 * 总的记录
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Data
@TableName("tb_total_cord")
@EqualsAndHashCode(callSuper = true)
public class TbTotalCord extends BaseEntity<TbTotalCord> {

    private static final long serialVersionUID = 1L;

    /**
     * 批次id
     */
    @TableField("batch_id")
    private String batchId;
    @TableField("total_money")
    private String totalMoney;


}
