package com.springboot.mybatisplus.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import com.springboot.mybatisplus.validator.ValidatorConstant;
import com.springboot.mybatisplus.validator.group.AddGroup;
import com.springboot.mybatisplus.validator.group.UpdateGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户表
 *
 * @author nick
 * @email sunlightcs@gmail.com
 * @date 2018-05-03 09:50:54
 */
@Data
@TableName("tb_dsf_user")
@ApiModel(description = "用户表")
public class DsfUserEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 用户ID
     */
    @TableId
    @ApiModelProperty(value = "用户ID", example = "1")
    private Long userId;
    /**
     * 用户名
     */
    @Pattern(message = "帐号长度1-16个字符，由字母、数字、点(.)、减号(-)、空格或下划线(_)", regexp = ValidatorConstant.ACCOUNT_PATTERN, groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "帐号", example = "测试帐号001")
    @Length(message = "帐号不能超过16个字符", max = 16, groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(message = "帐号不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String userName;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", example = "测试密码001")
    @Length(message = "密码不能超过100个字符", max = 100, groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(message = "密码不能为空", groups = {AddGroup.class})
    private String password;
    /**
     * 电话
     */
    @ApiModelProperty(value = "电话", example = "测试电话001")
    @Length(message = "电话不能超过32个字符", max = 32, groups = {AddGroup.class, UpdateGroup.class})
    private String mobile;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态", example = "1")
    @Length(message = "状态不能超过2个字符", max = 2, groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(message = "状态不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String status;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", example = "2018-08-08")
    @NotNull(message = "创建时间不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private Date gmtCreated;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间", example = "2018-08-08")
    @NotNull(message = "更新时间不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private Date gmtModified;
    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人", example = "测试创建人001")
    @Length(message = "创建人不能超过16个字符", max = 16, groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(message = "创建人不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String gmtAuthor;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "最后登录时间", example = "2018-08-08")
    private Date lastLoginTime;
    /**
     * 帐号类别
     */
    @ApiModelProperty(value = "帐号类别（0 : 内部用户，1 : 外部用户）", example = "0")
    @Length(message = "帐号类别不能超过1个字符", max = 1, groups = {AddGroup.class, UpdateGroup.class})
    private String userType;
    /**
     * 最后登录ip
     */
    @ApiModelProperty(value = "最后登录ip", example = "127.0.0.1")
    @Length(message = "最后登录ip不能超过20个字符", max = 20, groups = {AddGroup.class, UpdateGroup.class})
    private String lastLoginIp;
    /**
     * 盐值
     */
    @ApiModelProperty(value = "盐值", example = "盐值001")
    private String salt;
    /**
     * 用户中文名
     */
    @ApiModelProperty(value = "用户中文名")
    private String personName;


    /**
     * 用户组ID
     */
    @ApiModelProperty(value = "用户组ID", example = "1")
    @TableField(exist = false)
    private Long groupId;
    /**
     * 角色ID列表
     */
    @ApiModelProperty(value = "角色ID列表")
    @TableField(exist = false)
    private List<Long> roleIdList;
    /**
     * 角色列表
     */
    @ApiModelProperty(value = "角色列表")
    @TableField(exist = false)
    private List<DsfRoleEntity> roles;
    /**
     * 职位
     */
    @ApiModelProperty(value = "职位", example = "科员")
    @TableField(exist = false)
    private String usertitle;
    /**
     * 通讯录ID
     */
    @ApiModelProperty(value = "通讯录ID", example = "1")
    @TableField(exist = false)
    private Long resouresPersonId;
    /**
     * 通讯录ID
     */
    @ApiModelProperty(value = "通讯录名称", example = "994_圣墟")
    @TableField(exist = false)
    private String resouresPersonName;


    public DsfUserEntity(Long userId) {
        this.userId = userId;
    }

}
