package com.springboot.mybatisplus.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 角色授权对应的用户信息
 *
 * @author admin
 */
@Data
public class RoleAuthorizeVo implements Serializable {

    @ApiModelProperty(value = "用户ID", example = "1")
    private Long userId;

    @ApiModelProperty(value = "角色ID", example = "1")
    private Long roleId;

    @ApiModelProperty(value = "人员姓名", example = "测试人员姓名001")
    private String personName;

    @ApiModelProperty(value = "用户名", example = "测试用户名001")
    private String userName;

    @ApiModelProperty(value = "职位", example = "科员")
    private String usertitle;

    @ApiModelProperty(value = "部门名称", example = "部门名称001")
    private String deptName;

    @ApiModelProperty(value = "电话", example = "测试电话001")
    private String mobile;

    @ApiModelProperty(value = "状态", example = "1")
    private String status;

}
