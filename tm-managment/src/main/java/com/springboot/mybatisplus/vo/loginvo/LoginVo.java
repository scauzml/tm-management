package com.springboot.mybatisplus.vo.loginvo;

import com.springboot.mybatisplus.validator.group.AddGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author{张明亮} 2019/1/29 9:55
 */
@ApiModel("登录")
@Data
public class LoginVo {
    @ApiModelProperty(value="登录邮箱账号",example = "13828607279@163.com")
    @NotBlank(message = "账号不能为空")
    private String email;
    @ApiModelProperty(value="登录密码",example = "123456")
    @NotBlank(message = "密码不能为空")
    private String password;

}
