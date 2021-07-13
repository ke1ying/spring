package com.alibaba.tx;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 事务配置类
 * 环境搭建：数据源，数据库、spring-jdbc
 * 配置数据源：JdbcTemplate操作数据(spring提供的操作数据工具)
 *
 * 1、给方法上加上@Transactional
 * 2、给配置文件加上@EnableTransactionManagement开启事务管理
 * 3、配置事务管理器控制事务
 *
 * @author keying
 */
@EnableTransactionManagement
@Configuration
@ComponentScan("com.alibaba.tx")
public class TxConfig {

    @Bean
    public DataSource dataSource() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/testmac");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    /**
     * spring对@Configuration有特殊处理，给容器中加组件的方法，多次调用也只是在容器中找组件
     */
    @Bean
    public JdbcTemplate jdbcTemplate() throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate;
    }

    /**
     * 事务管理器
     */
    @Bean
    public PlatformTransactionManager transactionManager() throws Exception {
        return new DataSourceTransactionManager(dataSource());
    }

}
