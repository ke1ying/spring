package com.alibaba;

import com.alibaba.aop.MathCalculator;
import com.alibaba.config.MyConfigAop;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author keying
 *
 * 自己实现AOP主要分为三步：
 * 1、自定义业务逻辑类 和 aop切面类，aop类加上@Aspect切面注解。
 * 2、给aop切面类每个方法加上注解，告知何时运行，切入点表达式@PointCut
 * 3、在配置类注解开启aop模式：@EnableAsceptAutoProxy
 */
public class AOPTestPointCut {

    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
            MyConfigAop.class);

        //这种自己创建的对象不会触发aop切面，需要从ioc容器中获取
      /*  MathCalculator mathCalculator = new MathCalculator();
        System.out.println(mathCalculator.div(1, 2));*/
        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        System.out.println("IOC容器获取后计算:" + mathCalculator.div(1, 2));

        //printBean(applicationContext);
        applicationContext.close();
    }

    private void printBean(AnnotationConfigApplicationContext applicationContext) {
        String[] strings = applicationContext.getBeanDefinitionNames();
        for (String name : strings) {
            System.out.println(name);
        }
    }
}
