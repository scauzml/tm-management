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
 * 库存表
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Data
@TableName("tb_store")
@EqualsAndHashCode(callSuper = true)
public class TbStore extends BaseEntity<TbStore> {

    private static final long serialVersionUID = 1L;


    @TableField("batch_id")
    private String batchId;
    @TableField("teacher_book_order_id")
    private String teacherBookOrderId;
    /**
     * 库存量
     */
    @TableField("storenum")
    private Integer storenum;
    /**
     * 已入库量
     */
    @TableField("instore_num")
    private Integer instoreNum;
    /**
     * 待入库量
     */
    @TableField("needinstore_num")
    private Integer needinstoreNum;
    /**
     * 入库状态（0 未完成入库 1 以完成入库）
     */
    @TableField("state_instore")
    private Integer stateInstore;
    /**
     * 出库状态（0 未完成出库，1 已完成出库）
     */
    @TableField("state_outstore")
    private Integer stateOutstore;
    /**
     * 已经出库的数量
     */
    @TableField("outedstore_num")
    private Integer outedstoreNum;
    /**
     * 待出库数量
     */
    @TableField("needout_store_num")
    private Integer needoutStoreNum;

}
