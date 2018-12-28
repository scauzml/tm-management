package com.springboot.mybatisplus.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.springboot.mybatisplus.dao.DsfUserTokenDao;
import com.springboot.mybatisplus.entity.DsfUserTokenEntity;
import com.springboot.mybatisplus.service.DsfUserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service("dsfUserTokenService")
public class DsfUserTokenServiceImpl extends ServiceImpl<DsfUserTokenDao, DsfUserTokenEntity> implements DsfUserTokenService {
    @Value("${do1.login.expire-min:30}")
    private int expire_min;

    //多用户登录（允许多用户登录同一账户），默认false（不开启）
    @Value("${do1.authorize.multi-user:false}")
    private boolean multiUser;

    @Value("${spring.redis.open:false}")
    private boolean redisOpen;

    @Autowired
    private DsfUserTokenDao dsfUserTokenDao;
    @Autowired
    private DsfTokenRedis dsfTokenRedis;

    @Override
    public DsfUserTokenEntity createToken(long userId) {
        String token = null;
        //查询是否生成过Token
        DsfUserTokenEntity tokenEntity = this.selectById(userId);
        if (tokenEntity == null || !multiUser) {
            //生成一个token
            token = TokenGenerator.generateValue();
        } else {
            //保持旧token可用，不影响已登录用户
            token = tokenEntity.getToken();
        }

        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + expire_min * 1000 * 60);

        //判断是否生成过token
        if (tokenEntity == null) {
            tokenEntity = new DsfUserTokenEntity();
            tokenEntity.setUserId(userId);
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);
            //保存token
            if (redisOpen) {
                dsfTokenRedis.saveOrUpdate(tokenEntity);
            } else {
                this.insert(tokenEntity);
            }

        } else {
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);
            //更新token
            if (redisOpen) {
                dsfTokenRedis.saveOrUpdate(tokenEntity);
            } else {
                this.updateById(tokenEntity);
            }
        }

        return tokenEntity;
    }

    @Override
    public DsfUserTokenEntity createToken(long userId, String token) {
//		String token = null;
//		//查询是否生成过Token
        DsfUserTokenEntity tokenEntity = this.selectById(userId);
//		if(tokenEntity==null||!multiUser){
//			//生成一个token
//			token = TokenGenerator.generateValue();
//		}else{
//			//保持旧token可用，不影响已登录用户
//			token = tokenEntity.getToken();
//		}

        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + expire_min * 1000 * 60);

        //判断是否生成过token
        if (tokenEntity == null) {
            tokenEntity = new DsfUserTokenEntity();
            tokenEntity.setUserId(userId);
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);

            //保存token
            if (redisOpen) {
                dsfTokenRedis.saveOrUpdate(tokenEntity);
            } else {
                this.insert(tokenEntity);
            }
        } else {
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);
            //更新token
            if (redisOpen) {
                dsfTokenRedis.saveOrUpdate(tokenEntity);
            } else {
                this.updateById(tokenEntity);
            }
        }

        return tokenEntity;
    }

    @Override
    public void logout(long userId) {
        //生成一个token
        String token = TokenGenerator.generateValue();

        //修改token
        DsfUserTokenEntity tokenEntity = new DsfUserTokenEntity();
        tokenEntity.setUserId(userId);
        tokenEntity.setToken(token);
        if (redisOpen) {
            dsfTokenRedis.saveOrUpdate(tokenEntity);
        } else {
            this.updateById(tokenEntity);
        }
    }

    /**
     * 查询redis中的token
     *
     * @param token
     * @return
     */
    @Override
    public DsfUserTokenEntity queryByToken(String token) {
        if (redisOpen) {
            return dsfTokenRedis.get(token);
        } else {
            return dsfUserTokenDao.queryByToken(token);
        }
    }
}
