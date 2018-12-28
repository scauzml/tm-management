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

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 角色表
 *
 * @author
 * @email innovation@do1.com.cn
 * @date 2018-05-03 09:26:16
 */
@Data
@TableName("tb_dsf_role")
@ApiModel(description = "系统角色")
public class DsfRoleEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
    @TableId
    @ApiModelProperty(value = "角色id", example = "1")
    private Long id;
    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称", example = "角色名称001")
    @Pattern(message = "角色名称长度1-32个字符，由中文，数字，字母组成", regexp = ValidatorConstant.ROLE_PATTERN, groups = {AddGroup.class, UpdateGroup.class})
    @Length(message = "名称不能超过32个字符", max = 32, groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(message = "角色名称不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String roleName;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", example = "")
    @Length(message = "备注不可超过256个字符", max = 256, groups = {AddGroup.class, UpdateGroup.class})
    private String roleRemark;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", example = "2018-08-08")
    private Date gmtCreated;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间", example = "2018-08-08")
    private Date gmtModified;
    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者ID", example = "001")
    private String gmtAuthor;






}
