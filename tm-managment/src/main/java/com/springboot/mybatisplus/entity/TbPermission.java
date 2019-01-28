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
 * 权限表
 * </p>
 *
 * @author ZML
 * @since 2019-01-28
 */
@Data
@TableName("tb_permission")
@EqualsAndHashCode(callSuper = true)
public class TbPermission extends BaseEntity<TbPermission> {

    private static final long serialVersionUID = 1L;


    /**
     * 权限代码
     */
    @TableField("permission_code")
    private String permissionCode;
    /**
     * 权限名字
     */
    @TableField("permission_name")
    private String permissionName;


}
