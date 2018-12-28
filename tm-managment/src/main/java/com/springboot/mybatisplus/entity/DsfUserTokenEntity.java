package com.springboot.mybatisplus.entity;


import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 系统用户Token
 */
@Data
@TableName("tb_dsf_user_token")
public class DsfUserTokenEntity implements UserTokenEntity, Serializable {
    private static final long serialVersionUID = 1L;

    //用户ID
    @TableId(type = IdType.INPUT)
    private Long userId;
    //token
    private String token;
    //过期时间
    private Date expireTime;
    //更新时间
    private Date updateTime;

    /**
     * 获取：用户ID
     */
    @Override
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置：用户ID
     */
    @Override
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取：token
     */
    @Override
    public String getToken() {
        return token;
    }

    /**
     * 设置：token
     */
    @Override
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 获取：过期时间
     */
    @Override
    public Date getExpireTime() {
        return expireTime;
    }

    /**
     * 设置：过期时间
     */
    @Override
    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    /**
     * 获取：更新时间
     */
    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置：更新时间
     */
    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
