package com.alibaba;

import com.alibaba.bean.Person;
import com.alibaba.config.MyConfigPropertyValues;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author keying
 */
public class IOCTestPropertyValues {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
        MyConfigPropertyValues.class);

    @Test
    public void test1() {
        getBeanNames(applicationContext);
        Person person = (Person)applicationContext.getBean("person");
        System.out.println(person.toString());

        System.out.println("加载环境变量中的数据，配置文件的数据也会被@PropertySource注解加载进环境变量中");
        ConfigurableEnvironment configurableEnvironment = applicationContext.getEnvironment();
        String valueName = configurableEnvironment.getProperty("value.name");
        System.out.println("环境变量中的：" + valueName);
        applicationContext.close();
    }

    private void getBeanNames(AnnotationConfigApplicationContext applicationContext) {
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

}
