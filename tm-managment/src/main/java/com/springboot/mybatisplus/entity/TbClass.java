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
 * 班级
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Data
@TableName("tb_class")
@EqualsAndHashCode(callSuper = true)
public class TbClass extends BaseEntity<TbClass> {

    private static final long serialVersionUID = 1L;

    /**
     * 学院id
     */
    @TableField("academy_id")
    private String academyId;
    /**
     * 班级名称
     */
    @TableField("class_name")
    private String className;
    /**
     * 年级
     */
    @TableField("class_year")
    private String classYear;

}
