package com.springboot.mybatisplus.annonation;

import java.lang.annotation.*;

/**
 * 系统日志注解
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017年3月8日 上午10:19:56
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

    /**
     * 操作名称
     * @return
     */
    String value() default "";

    /**
     * 日志类型
     * @return
     */
    LogType type() default LogType.BUSSINESS;

}
