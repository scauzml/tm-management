package com.springboot.mybatisplus.entity
        ;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author{张明亮} 2018/12/23 21:46
 */
@Data
@TableName("role")
public class Role extends Model<Role> implements Serializable {

    @ApiParam("主键id")
    @TableId(value="id")
    private Long id;
    @ApiParam("角色名字")
    @TableId(value="role_name")
    private String roleName;
    /**
     * 使用数据库时间,输出 SQL 为：update 表 set 字段=now() where ...
     */
    @ApiParam("更新时间")
    @TableField(exist = false)
    private String modifyTime;

    /**
     * 表示类中有的属性，而对应的属性在表中没有这样的一个字段,不映射
     */
    @TableField(exist = false)
    private String testField;
    @TableField(exist = false)
    private User user;
    @TableField(exist = false)
    private List<Permission> permissions;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
