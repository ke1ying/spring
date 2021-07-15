package com.alibaba;

import com.alibaba.aop.MathCalculator;
import com.alibaba.config.MyConfigAop;
import com.alibaba.ext.ExtConfig;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author keying
 *
 */
public class AOPTestExt {

    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtConfig.class);

        applicationContext.close();
    }

}
