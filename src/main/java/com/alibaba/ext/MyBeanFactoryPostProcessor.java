package com.alibaba.ext;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author keying
 * @date 2021/7/15
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("myBeanFactoryPostProcessor。。。。。");
        int count = beanFactory.getBeanDefinitionCount();
        System.out.println("当前beanFactory几个 bean:" + count);
        String[] strings = beanFactory.getBeanDefinitionNames();
        System.out.println("当前bean名称：" + Arrays.asList(strings));
    }
}
