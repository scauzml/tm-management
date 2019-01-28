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
 * 用户
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Data
@TableName("tb_user")
@EqualsAndHashCode(callSuper = true)
public class TbUser extends BaseEntity<TbUser> {

    private static final long serialVersionUID = 1L;


    /**
     * 学院id
     */
    @TableField("academy_id")
    private String academyId;
    @TableField("class_id")
    private String classId;
    /**
     * 学生id
     */
    @TableField("user_studentid")
    private String userStudentid;
    /**
     * 教师工号
     */
    @TableField("user_workid")
    private String userWorkid;
    /**
     * 真实姓名
     */
    @TableField("name")
    private String name;
    /**
     * 手机号码
     */
    @TableField("phone")
    private String phone;
    /**
     * 邮箱
     */
    @TableField("email")
    private String email;
    /**
     * 密码
     */
    @TableField("password")
    private String password;
    /**
     * 用户类别（0为学生，1为老师，2为管理员，3财务，4教务处，5院系）
     */
    @TableField("type_user")
    private Integer typeUser;
    /**
     * 工系
     */
    @TableField("work_belong")
    private String workBelong;

}
