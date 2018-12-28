package com.springboot.mybatisplus.entity;

import java.util.Date;

public interface UserTokenEntity {

    /**
     * 获取：用户ID
     */
    Long getUserId();

    /**
     * 设置：用户ID
     */
    void setUserId(Long userId);

    /**
     * 获取：token
     */
    String getToken();

    /**
     * 设置：token
     */
    void setToken(String token);

    /**
     * 获取：过期时间
     */
    Date getExpireTime();

    /**
     * 设置：过期时间
     */
    void setExpireTime(Date expireTime);

    /**
     * 获取：更新时间
     */
    Date getUpdateTime();

    /**
     * 设置：更新时间
     */
    void setUpdateTime(Date updateTime);
}
