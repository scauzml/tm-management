package com.springboot.mybatisplus.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author zws
 * @date 2018/7/30
 * 基本数据
 * swy 20180903 增加字段填充注解
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseEntity<E extends Model> extends BaseIdEntity<E> implements Serializable {

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间",example = "2019-01-03")
    @TableField("create_time")
    private Date createTime;
    /**
     * 创建人
     */
    @ApiModelProperty(value="创建人",example = "张明亮")
    @TableField("create_people")
    private String createPeople;
    /**
     * 修改人
     */
    @ApiModelProperty(value="修改人",example = "张明亮")
    @TableField("modify_people")
    private String modifyPeople;
    /**
     * 修改时间
     */
    @ApiModelProperty(value="修改时间",example = "2019-01-03")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date modifyTime;

}
