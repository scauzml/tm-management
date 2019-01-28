package com.springboot.mybatisplus.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.enums.FieldFill;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 *
 * @author zws
 * @date 2018/9/13
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseIdEntity<E extends Model> extends Model<E> implements Serializable {
    /**
     * 主键ID
     */
    @TableId
    @ApiModelProperty(value = "主键ID", example = "1")
    private String id;

    /**
     * 是否删除 0 否 1 是
     */
    @ApiModelProperty(value = "是否删除 0 否 1 是", example = "0", hidden = true)
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer isDel;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
