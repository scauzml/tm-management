package com.springboot.mybatisplus.service;

/**
 * 登录锁控制
 */
public interface DsfUserLoginLockService {

    /**
     * 累计登录错误次数
     * @param username
     */
    void addFailTimes(String username);

    /**
     * 清除登录错误次数
     * @param username
     */
    void clearFailTimes(String username);

    /**
     * 检查登录失败次数，若超过最大次数，则抛出异常
     * @param username
     */
    void checkFailTimes(String username);
    
}
