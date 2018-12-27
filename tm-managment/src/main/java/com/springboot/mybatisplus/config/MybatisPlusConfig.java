package com.springboot.mybatisplus.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author{张明亮} 2018/12/22 16:22
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.springboot.mybatisplus.dao")
public class MybatisPlusConfig {
    /**
     * @return
     * @author {张明亮}
     * @date 2018/12/22 16:24
     * @Param: null
     * @description {数据源}
     */
    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    /**
     * @return
     * @author {张明亮}
     * @date 2018/12/22 16:26
     * @Param: null
     * @description {事务管理器}
     */
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    /**
     *@author {张明亮}
     *@date 2018/12/22 16:28
     * @Param: null
     *@return
     *@description {mybatis-plus 分页插件}
     *
     */
    /**
     * mybatis-plus 分页插件
     *
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }

}
