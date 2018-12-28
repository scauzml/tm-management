package com.springboot.mybatisplus.annonation;

/**
 * 日志类型
 *
 * @author fengshuonan
 * @Date 2017年1月22日 下午12:14:59
 */
public enum LogType {

    /**
     * 后台登录日志
     */
    LOGIN("后台登录日志"),
    LOGIN_FAIL("后台登录失败日志"),
    EXIT("后台退出日志"),
    EXIT_FAIL("后台退出失败日志"),
    
    WEB_LOGIN("前台登录日志"),
    WEB_LOGIN_FAIL("前台登录失败日志"),
    WEB_EXIT("前台退出日志"),
    WEB_EXIT_FAIL("前台退出失败日志"),
    
    EXCEPTION("异常日志"),
    BUSSINESS("业务日志"),
	SUCCESS("成功"),
    FAIL("失败");
	
    String message;

    LogType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
