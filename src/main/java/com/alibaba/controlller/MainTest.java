package com.alibaba.controlller;

import com.alibaba.bean.Person;
import com.alibaba.config.BeanConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * test
 *
 * @author keying
 * @date 2021/6/24
 */
public class MainTest {

    public static void main(String[] args) {
        //配置文件加载对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person)applicationContext.getBean("person");
        System.out.println(person.toString());
        //注解加载对象
        ApplicationContext applicationContextAnnotation = new AnnotationConfigApplicationContext(BeanConfig.class);
        Person personByAnnotation = applicationContextAnnotation.getBean(Person.class);
        System.out.println(personByAnnotation.toString());
        String[] typeName = applicationContextAnnotation.getBeanNamesForType(Person.class);
        for (String type : typeName) {
            System.out.println(type);
        }

    }
}
