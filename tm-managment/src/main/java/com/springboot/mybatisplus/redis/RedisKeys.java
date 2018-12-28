package com.springboot.mybatisplus.redis;

/**
 * Redis所有Keys
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-18 19:51
 */
public class RedisKeys {

    public static String getConfigKey(String key) {
        return "do1:config:" + key;
    }

    public static String getTokenKey(String key) {
        return "do1:token:" + key;
    }

    public static String getUserKey(String key) {
        return "do1:user:" + key;
    }

    public static String getPermissionsKey(String key) {
        return "do1:permissions:" + key;
    }

    public static String getMunePermissionsKey(String key) {
        return "do1:munepermissions:" + key;
    }
}
