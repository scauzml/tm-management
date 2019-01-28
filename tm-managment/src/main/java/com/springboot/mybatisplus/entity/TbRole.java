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
 * 角色表
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Data
@TableName("tb_role")
@EqualsAndHashCode(callSuper = true)
public class TbRole extends BaseEntity<TbRole> {

    private static final long serialVersionUID = 1L;


    /**
     * 角色名字
     */
    @TableField("role_name")
    private String roleName;
    /**
     * 角色说明
     */
    @TableField("role_remark")
    private String roleRemark;

}
