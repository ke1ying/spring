package com.alibaba.config;

import com.alibaba.bean.Car;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * bean生命周期：
 *    bean创建 ---> 初始化 ---> 销毁
 * 容器管理bean的生命周期
 * 我们可以自定义初始化和销毁，bean进行到当前生命周期的时候，调用自定义的创建和销毁
 *
 * 构造(对象创建)：
 *        单实例，容器创建的时候construct创建对象和init初始化。
 *        多实例，获取对象的时候construct创建对象和init初始化。不会交给ioc容器管理，所以容器关闭不会销毁。
 *
 *  1）通过@Bean注释 init-method和destory-method的两个方法，指定对象的创建和销毁。
 *    什么时候调用：初始化，对象创建完成，并且赋值好，开始调用。
 *                销毁，容器关闭的时候调用。(多实例的时候不会调用销毁，因为容器不会管理这个bean)
 *
 * @author keying
 */
@Configuration
@ComponentScan("com.alibaba.bean")
public class ConfigLifeCycle {
    //@Scope("prototype")
    @Bean(initMethod = "init", destroyMethod = "destory")
    public Car car(){
        return new Car();
    }
}
