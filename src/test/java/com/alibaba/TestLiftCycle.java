package com.alibaba;

import com.alibaba.config.ConfigLifeCycle;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author keying
 * @date 2021/6/28
 */
public class TestLiftCycle {


    @Test
    public void test() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(
            ConfigLifeCycle.class);
        System.out.println("容器创建完毕");
        //多实例情况下，需要获取组件，才会初始化，并且不会销毁
        Object carObject = annotationConfigApplicationContext.getBean("car");

        //getDefinitionNames(annotationConfigApplicationContext);
        annotationConfigApplicationContext.close();
    }

    private void getDefinitionNames(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
        String[] names = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("注入IOC容器的Bean:" + name);
        }
    }
}
