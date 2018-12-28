package com.springboot.mybatisplus.entity;


import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.springboot.mybatisplus.validator.group.AddGroup;
import com.springboot.mybatisplus.validator.group.UpdateGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 人员表
 *
 * @author nick
 * @email sunlightcs@gmail.com
 * @date 2018-05-03 09:52:53
 */
@Data
@TableName("tb_dsf_person")
@ApiModel(description = "人员表")
public class DsfPersonEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId
    @ApiModelProperty(value = "ID", example = "1")
    private Long personId;
    /**
     * 人员姓名
     */
    @ApiModelProperty(value = "姓名", example = "测试姓名001")
    @Length(message = "姓名不能超过128个字符", max = 128, groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(message = "姓名不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String personName;
    /**
     * 性别
     */
    @ApiModelProperty(value = "性别", example = "1")
    private Integer gender;
    /**
     * 职位
     */
    @ApiModelProperty(value = "职位", example = "测试职位001")
    @Length(message = "职位不能超过256个字符", max = 256, groups = {AddGroup.class, UpdateGroup.class})
    private String title;
    /**
     * 电话
     */
    @ApiModelProperty(value = "电话", example = "测试电话001")
    @Length(message = "电话不能超过32个字符", max = 32, groups = {AddGroup.class, UpdateGroup.class})
    private String telephone;
    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱", example = "测试邮箱001")
    @Length(message = "邮箱不能超过64个字符", max = 64, groups = {AddGroup.class, UpdateGroup.class})
    private String email;
    /**
     * 头像
     */
    @ApiModelProperty(value = "头像", example = "测试头像001")
    @Length(message = "头像不能超过100个字符", max = 100, groups = {AddGroup.class, UpdateGroup.class})
    private String avatar;
    /**
     * 地址
     */
    @ApiModelProperty(value = "地址", example = "测试地址001")
    @Length(message = "地址不能超过128个字符", max = 128, groups = {AddGroup.class, UpdateGroup.class})
    private String address;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", example = "测试备注001")
    @Length(message = "备注不能超过256个字符", max = 256, groups = {AddGroup.class, UpdateGroup.class})
    private String remark;
    /**
     * 自定义字段
     */
    @ApiModelProperty(value = "自定义字段", example = "测试自定义字段001")
    @Length(message = "自定义字段不能超过200个字符", max = 200, groups = {AddGroup.class, UpdateGroup.class})
    private String extattr;
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

}
