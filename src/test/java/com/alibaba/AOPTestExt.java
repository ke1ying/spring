package com.alibaba;

import com.alibaba.aop.MathCalculator;
import com.alibaba.config.MyConfigAop;
import com.alibaba.ext.ExtConfig;

import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author keying
 *
 */
public class AOPTestExt {

    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtConfig.class);
        applicationContext.publishEvent(new ApplicationEvent("自定义发布事件") {});

        applicationContext.close();
    }

}
