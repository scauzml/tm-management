package com.springboot.mybatisplus.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.io.Serializable;

/**
 * @author{张明亮} 2018/12/26 22:08
 */
@Data
@TableName("pm_role")
public class SecRolePermission extends Model<SecRolePermission> implements Serializable {

    @ApiParam("权限id")
    @TableField(value = "pm")
    private Long pm;
    @ApiParam("角色id")
    @TableField(value = "role")
    private Long role;

    @Override
    protected Serializable pkVal() {
        return this.role;
    }
}
