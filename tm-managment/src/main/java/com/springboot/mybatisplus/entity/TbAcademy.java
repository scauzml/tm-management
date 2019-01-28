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
 * 学院
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Data
@TableName("tb_academy")
@EqualsAndHashCode(callSuper = true)
public class TbAcademy extends BaseEntity<TbAcademy> {

    private static final long serialVersionUID = 1L;


    /**
     * 学院编码
     */
    @TableField("academy_code")
    private String academyCode;
    /**
     * 学院名字
     */
    @TableField("academy_name")
    private String academyName;



}
