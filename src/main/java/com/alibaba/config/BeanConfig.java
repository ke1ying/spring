package com.alibaba.config;

import com.alibaba.bean.Person;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置文件
 * @Configuration 告诉spring这是一个配置类
 *
 * @author keying
 * @date 2021/6/24
 */
@Configuration
public class BeanConfig {

    /**
     * @Bean吧对象注入给spring容器
     * 1、id默认是方法名，value方法可以指定方法名
     * @return Person
     */
    @Bean(value = "person")
    public Person getPerson(){
        return new Person("李四",19);
    }
}
