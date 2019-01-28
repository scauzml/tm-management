package com.springboot.mybatisplus.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 角色权限表
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Data
@TableName("tb_role_permission_r")
@EqualsAndHashCode(callSuper = true)
public class TbRolePermissionR extends BaseEntity<TbRolePermissionR> {

    private static final long serialVersionUID = 1L;


    @TableField("tb_role_id")
    private String tbRoleId;
    @TableField("tb_permission_id")
    private String tbPermissionId;


}
