package com.alibaba.aop;

/**
 * @author keying
 */
public class MathCalculator {

    public int div(Integer i, Integer z) {
        //我们可以吧日志写在这里，但这是一种耦合的方式，并不符合aop编程思想
        //System.out.println("打印日志！");
        System.out.println("div正在计算。。。");
        return i / z;
    }

}
