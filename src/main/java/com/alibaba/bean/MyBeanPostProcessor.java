package com.alibaba.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 自定义类实现beanPostProcessor接口，两个重写的方法在bean初始化前后调用。
 *
 * 初始化之前用populateBean()方法，给bean属性赋值
 * 初始化开始：
 * 「
 * applyBeanPostProcessorsBeforeInitialization()初始化之前调用的方法 ， 接口BeanPostProcessor
 * invokeInitMethods()方法初始化 ，执行bean初始化
 * applyBeanPostProcessorsAfterInitialization()初始化之后调用的方法 ， 接口BeanPostProcessor
 * 」
 *
 * @author keying
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(
            "postProcessBeforeInitialization.....Before..." + bean.getClass() + ",【beanName】=" + beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(
            "postProcessAfterInitialization.....After..." + bean.getClass() + ",【beanName】=" + beanName);
        return bean;
    }
}
