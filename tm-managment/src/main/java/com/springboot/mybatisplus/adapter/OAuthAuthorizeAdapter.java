package com.springboot.mybatisplus.adapter;

import com.springboot.mybatisplus.entity.UserTokenEntity;

/**
 * 授权适配器
 */
public interface OAuthAuthorizeAdapter {

    /**
     * 给某用户授权，并返回Token
     *
     * @param userId
     * @return
     */
    UserTokenEntity createToken(long userId);

}
