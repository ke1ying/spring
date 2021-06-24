package com.alibaba;

import com.alibaba.config.BeanConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * junitTest
 *
 * @author keying
 * @date 2021/6/24
 */
public class Test {

    @org.junit.Test
    public void test() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(
            BeanConfig.class);
        String[] beanNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }
}
