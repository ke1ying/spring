package com.alibaba.ext;


import com.alibaba.bean.Car;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * beanPostProcessor:是bean的后置处理器，bean创建实例之后，初始化前后拦截的工作。
 * beanFactoryPostProcessor:是beanFactory的后置处理器。
 *  在beanFactory标准初始化之后调用：所有bean的定义已经保存加载到beanFactory，但还未创建bean实例。
 *
 * @author keying
 */
@Configuration
@ComponentScan("com.alibaba.ext")
public class ExtConfig {

    @Bean("carBean")
    public Car car(){
        return new Car();
    }
}
