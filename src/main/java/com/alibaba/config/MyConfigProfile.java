package com.alibaba.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import com.alibaba.bean.Yellow;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * @author keying
 * @Profile:根据我们的当前环境，动态的激活和切换一系列组件。 如test环境用test配置，dev环境用dev配置
 */
@PropertySource(value = {"classpath:/dataSources.properties"})
@Configuration
//@Profile("test")
public class MyConfigProfile implements EmbeddedValueResolverAware {

    @Value("${dataName}")
    private String user;

    private String driverClass;

    @Bean
    public Yellow yellow(){
        return new Yellow();
    }

    @Profile("test")
    @Bean("testDataSource")
    public DataSource test(@Value("${dataPassword}") String password) throws Exception {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/testmac");
        comboPooledDataSource.setDriverClass(driverClass);
        return comboPooledDataSource;
    }

    @Profile("dev")
    @Bean("devDataSource")
    public DataSource dev(@Value("${dataPassword}") String password) throws Exception {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/dev");
        comboPooledDataSource.setDriverClass(driverClass);
        return comboPooledDataSource;
    }

    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        //配置文件信息放入环境里，解析器从环境信息中获取
        this.driverClass = resolver.resolveStringValue("${data.driver.class}");
    }
}

