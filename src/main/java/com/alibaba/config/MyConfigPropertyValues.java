package com.alibaba.config;

import com.alibaba.bean.Person;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 使用@PropertySource注解，读取外部配置文件，吧k/v保存到环境变量中
 * @author keying
 */
@Configuration
@PropertySource(value = {"classpath:/application.properties"})
public class MyConfigPropertyValues {

    @Bean("person")
    public Person person(){
        return new Person();
    }
}
