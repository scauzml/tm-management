package com.springboot.mybatisplus.service.impl;


import com.springboot.mybatisplus.exception.RestException;
import com.springboot.mybatisplus.redis.RedisUtil;
import com.springboot.mybatisplus.service.DsfUserLoginLockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("dsfUserLoginLockService")
public class DsfUserLoginLockServiceImpl implements DsfUserLoginLockService {

    private final String REDIS_KEY_PREFIX = "do1:lock:login-fail-times";

    @Value("${do1.login.fail-lock-time:1800}")    //登录错误锁定时间，默认30分钟（单位秒）
    private Long failLockTime;

    @Value("${do1.login.fail-max-times:5}")     //最大错误次数，默认5次
    private Long failMaxTimes;

    @Autowired
    RedisUtil redisUtil;

    private String getRedisKey(String username){
        return REDIS_KEY_PREFIX + ":" + username;
    }

    @Override
    public void addFailTimes(String username) {
        String key = getRedisKey(username);
        Long times = getFailTimes(username);
        redisUtil.set(key, times+1, failLockTime);
    }

    @Override
    public void clearFailTimes(String username) {
        String key = getRedisKey(username);
        redisUtil.delete(key);
    }

    /**
     * 检查登录失败次数，若超过最大次数，则抛出异常
     * @param username
     */
    @Override
    public void checkFailTimes(String username){
        Long times = getFailTimes(username);
        if(times>failMaxTimes){
            throw new RestException("登录失败次数过多，请稍后再试");
        }
    }

    /**
     * 获取登录错误次数
     * @param username
     * @return
     */
    private Long getFailTimes(String username){
        String redisKey = getRedisKey(username);
        if(redisUtil.hasKey(redisKey)==null || !redisUtil.hasKey(redisKey)){
            return 0L;
        }
        return redisUtil.get(redisKey, Long.class);
    }

}
