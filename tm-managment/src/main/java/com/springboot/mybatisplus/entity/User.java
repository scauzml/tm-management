package com.springboot.mybatisplus.entity;

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
@TableName("user")
public class User extends Model<User> implements Serializable{

    @ApiParam("主键id")
    @TableId(value="id")
    private Long id;
    /**
     * TableField 的value可为空，驼峰命名方式自动识别
     */
    @ApiParam("姓名")
    @TableField(value="name")
    private String name;
    /**
     * TableField 的value可为空，驼峰命名方式自动识别
     */
    @ApiParam("密码")
    @TableField(value="password")
    private Integer password;


    /**
     * 使用数据库时间,输出 SQL 为：update 表 set 字段=now() where ...
     */
    @ApiParam("更新时间")
   @TableField(exist = false)
    private String modifyTime;
    @TableField(exist = false)
    private List<Role> roles;
//实现默认id方法
    //若一个表没有id 直接return null即可

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}

