package com.alibaba.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author keying
 * @Aspect:告诉springIOC,这是一个切面类
 */
@Aspect
public class LogAspects {

    /**
     * 抽取公共切入点表达式
     */
    @Pointcut("execution(public int com.alibaba.aop.MathCalculator.*(..))")
    public void pointCut() {

    }

    //业务方法之前切入
    //@Before("public int com.alibaba.aop.MathCalculator.div(Integer,Integer)")
    //@Before("public int com.alibaba.aop.MathCalculator.*(..)")
    @Before("pointCut()")
    public void start(JoinPoint joinPoint) {
        //获取切面目标方法名 和 参数列表
        Object[] objects = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName() + "计算开始 ---{" + Arrays.asList(objects) + "}");
    }

    //@After("public int com.alibaba.aop.MathCalculator.*(..)")
    @After("com.alibaba.aop.LogAspects.pointCut()")
    public void end() {
        System.out.println("计算结束 ---{}");
    }

    /**
     * 定义aop返回成功，用object接收返回成功参数
     * 重点，重点，重点：joinPoint必须写在参数第一位，否则spring无法解析
     */
    @AfterReturning(value = "pointCut()", returning = "object")
    public void returnSuccess(JoinPoint joinPoint, Object object) {
        System.out.println(joinPoint.getSignature().getName() + "计算返回成功 ---{" + object + "}");
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void returnException(Exception exception) {
        System.out.println("计算异常 ---{" + exception + "}");
    }
}
