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
 * 公告
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Data
@TableName("tb_notice")
@EqualsAndHashCode(callSuper = true)
public class TbNotice extends BaseEntity<TbNotice> {

    private static final long serialVersionUID = 1L;


    /**
     * 批次id
     */
    @TableField("batch_id")
    private String batchId;
    /**
     * 公告内容
     */
    @TableField("notice_content")
    private String noticeContent;




}
