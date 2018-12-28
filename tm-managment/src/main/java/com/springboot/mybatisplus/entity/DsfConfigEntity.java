/**
 * Copyright 2018 道一信息 http://do1.com.cn
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

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

/**
 * 系统配置信息
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年12月4日 下午6:43:36
 */
@Data
@TableName("tb_dsf_config")
@ApiModel(description = "系统配置")
public class DsfConfigEntity {
    @TableId
    @ApiModelProperty(value = "系统配置ID", example = "3")
    private Long id;

    @ApiModelProperty(value = "系统配置参数名", example = "3")
    @NotBlank(message = "参数名不能为空")
    @Length(message = "参数名不能超过50个字符", max = 50, groups = {AddGroup.class, UpdateGroup.class})
    private String configkey;

    @ApiModelProperty(value = "系统配置参数值", example = "3")
    @NotBlank(message = "参数值不能为空")
    @Length(message = "参数名不能超过2000个字符", max = 2000, groups = {AddGroup.class, UpdateGroup.class})
    private String configvalue;

    @ApiModelProperty(value = "系统配置备注", example = "3")
    @Length(message = "备注输入不能超过500个字符", max = 500, groups = {AddGroup.class, UpdateGroup.class})
    private String remark;

}
