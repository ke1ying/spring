package com.alibaba;

import com.alibaba.bean.Boss;
import com.alibaba.bean.Car;
import com.alibaba.bean.Color;
import com.alibaba.bean.Person;
import com.alibaba.config.ConfigOfAutowired;
import com.alibaba.config.MyConfigPropertyValues;
import com.alibaba.dao.BookDao;
import com.alibaba.service.BookService;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author keying
 */
public class IOCTestAutowired {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
        ConfigOfAutowired.class);

    @Test
    public void test1() {
        //getBeanNames(applicationContext);

        //BookService bookService = applicationContext.getBean(BookService.class);
        //BookDao bookDao = applicationContext.getBean(BookDao.class);
        //System.out.println("bookService:" + bookService);
        //System.out.println("bookDao:" + bookDao);
        System.out.println("=============从容器中获取Boss中的car========");
        Boss boss = applicationContext.getBean(Boss.class);
        System.out.println("boss:" + boss);
        Car car = applicationContext.getBean(Car.class);
        System.out.println("car:" + car);
        System.out.println("=============从Color中获取car");
        Color color = applicationContext.getBean(Color.class);
        System.out.println("color:" + color);

        applicationContext.close();
    }

    private void getBeanNames(AnnotationConfigApplicationContext applicationContext) {
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

}
