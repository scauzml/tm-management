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
 * 用户角色关系表
 *
 * @author nick
 * @email sunlightcs@gmail.com
 * @date 2018-05-03 10:49:05
 */
@Data
@TableName("tb_dsf_user_role_ref")
@ApiModel(description = "用户角色关系表")
public class DsfUserRoleRefEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId
    @ApiModelProperty(value = "ID", example = "1")
    private Long id;
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID", example = "1")
    @NotNull(message = "用户ID不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private Long userId;
    /**
     * 角色ID
     */
    @ApiModelProperty(value = "角色ID", example = "1")
    @NotNull(message = "角色ID不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private Long roleId;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", example = "2018-08-08")
    @NotNull(message = "创建时间不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private Date gmtCreated;
    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间", example = "2018-08-08")
    @NotNull(message = "修改时间不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private Date gmtModified;
    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人", example = "测试创建人001")
    @Length(message = "创建人不能超过16个字符", max = 16, groups = {AddGroup.class, UpdateGroup.class})
    @NotBlank(message = "创建人不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String gmtAuthor;

}
