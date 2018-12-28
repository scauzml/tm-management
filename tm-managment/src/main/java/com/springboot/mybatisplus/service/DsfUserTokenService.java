package com.springboot.mybatisplus.service;


import com.baomidou.mybatisplus.service.IService;
import com.springboot.mybatisplus.adapter.OAuthAuthorizeAdapter;
import com.springboot.mybatisplus.entity.DsfUserTokenEntity;

/**
 * 用户Token
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:22:07
 */
public interface DsfUserTokenService extends IService<DsfUserTokenEntity>, OAuthAuthorizeAdapter {

    /**
     * 生成token
     *
     * @param userId 用户ID
     */
    @Override
    DsfUserTokenEntity createToken(long userId);

    /**
     * 获得token
     *
     * @param token
     */
    DsfUserTokenEntity queryByToken(String token);

    /**
     * 生成token
     *
     * @param userId 用户ID
     */
    DsfUserTokenEntity createToken(long userId, String token);


    /**
     * 退出，修改token值
     *
     * @param userId 用户ID
     */
    void logout(long userId);

}
