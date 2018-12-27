package com.springboot.mybatisplus.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.io.Serializable;

/**
 * @author{张明亮} 2018/12/26 22:07
 */
@Data
@TableName("user_role")
public class SecUserRole extends Model<SecUserRole> implements Serializable {
    @ApiParam("用户id")
    @TableField(value = "userid")
    private Long userid;
    @ApiParam("角色id")
    @TableField(value = "roleid")
    private Long roleid;

    @Override
    protected Serializable pkVal() {
        return this.userid;
    }

}
