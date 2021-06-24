package com.alibaba;

import com.alibaba.bean.Person;
import com.alibaba.config.BeanConfig;
import com.alibaba.config.BeanConfig2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * junitTest
 *
 * @author keying
 * @date 2021/6/24
 */
public class Test {

    /**
     * @ComponentScan
     */
    @org.junit.Test
    public void test() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(
            BeanConfig.class);
        String[] beanNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }

    /**
     * @Scope
     */
    @org.junit.Test
    public void test2() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(
            BeanConfig2.class);
        System.out.println("springIOC容器加载完毕!");
        Person person1 = (Person)annotationConfigApplicationContext.getBean("person2");
        Person person2 = (Person)annotationConfigApplicationContext.getBean("person2");
        System.out.println(person1 == person2);
    }
}
