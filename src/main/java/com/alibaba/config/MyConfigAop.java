package com.alibaba.config;

import com.alibaba.aop.LogAspects;
import com.alibaba.aop.MathCalculator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * AOP：动态代理。(编程思想)
 * 在程序运行时候，动态的将某段代码插入项目中指定位子的编程方式。
 *
 * 测试思想：
 * 定义一个业务逻辑类，在程序运行的时候，将他的日志打印(运行之前，运行之后，运行正常返回，计算异常等等)。
 * 定义一个日志切面类，动态的感知业务逻辑运行到哪里。
 * 通知方法：
 * 1)、前置通知（@Before）:start，目标业务运行之前运行
 * 2)、后置通知(@After)：end,目标业务运行结束之后运行。（无论正常结束还是异常结束）
 * 3)、返回通知(@AfterReturning):returnSuccess,目标业务运行成功
 * 4)、异常通知(@AfterThrowing)：returnException，目标业务运行异常
 * 5)、环绕通知(@Around)：动态代理，手动推进目标业务运行，joinPoint。
 *
 * @EnableAspectAutoProxy开启基于注解的aop模式代理
 *
 * @author keying
 */
@EnableAspectJAutoProxy
@Configuration
@Import({LogAspects.class})
public class MyConfigAop {

    @Bean(value = "mathCalculator")
    public MathCalculator mathCalculator(){
        return new MathCalculator();
    }

  /*  @Bean(value = "logAspects")
    public LogAspects logAspects(){
        return new LogAspects();
    }*/
}
