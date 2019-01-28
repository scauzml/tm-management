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
 * 用户角色关系表
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Data
@TableName("tb_user_role_r")
@EqualsAndHashCode(callSuper = true)
public class TbUserRoleR extends BaseEntity<TbUserRoleR> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableField("user_id")
    private String userId;
    /**
     * 角色id
     */
    @TableField("role_id")
    private String roleId;


}
