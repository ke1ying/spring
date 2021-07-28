package com.alibaba;

import com.alibaba.ext.ExtConfig;
import com.alibaba.ext.MyAlibaba;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.MessageSource;
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


        MyAlibaba myAlibaba = new MyAlibaba(applicationContext,"123");
        applicationContext.publishEvent(myAlibaba);

        applicationContext.close();
    }

}
