package com.springboot.mybatisplus.redis;


import com.springboot.mybatisplus.entity.DsfConfigEntity;
import com.springboot.mybatisplus.entity.DsfUserTokenEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author carwen
 * @create 2018/5/24 14:21
 * @desc 系统管理-会话配置Redis
 **/
@Component
public class DsfTokenRedis {

    @Autowired
    RedisUtil redisUtil;

    public void saveOrUpdate(DsfUserTokenEntity config) {
        if (config == null) {
            return;
        }
        String key = RedisKeys.getTokenKey(config.getToken());
        redisUtil.set(key, config);
    }

    public void delete(String configKey) {
        String key = RedisKeys.getTokenKey(configKey);
        redisUtil.delete(key);
    }

    public DsfUserTokenEntity get(String configKey) {
        String key = RedisKeys.getTokenKey(configKey);
        return redisUtil.get(key, DsfUserTokenEntity.class);
    }

    public void saveOrUpdate(DsfConfigEntity config) {
        if (config == null) {
            return;
        }
        String key = RedisKeys.getConfigKey(config.getConfigkey());
        redisUtil.set(key, config);
    }

    public DsfConfigEntity getdsfconfig(String configKey) {
        String key = RedisKeys.getConfigKey(configKey);
        return redisUtil.get(key, DsfConfigEntity.class);
    }

}