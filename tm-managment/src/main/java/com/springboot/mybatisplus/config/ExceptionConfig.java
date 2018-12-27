package com.springboot.mybatisplus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

/**
 * @author zhangmingliang
 * @date 2018-12-27 10:10
 *该类配置Shiro未授权跳转
 */
public class ExceptionConfig {
    /**
     * 该类配置Shiro未授权跳转
     * @return
     */
    @Bean
    public SimpleMappingExceptionResolver resolver() {
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        Properties properties = new Properties();
        properties.setProperty("org.apache.shiro.authz.UnauthorizedException", "/403");
        resolver.setExceptionMappings(properties);
        return resolver;
    }

}
