package com.alibaba.bean;

/**
 * @author keying
 * @date 2021/6/28
 */
public class Car {

    public Car(){
        System.out.println("car ... construct");
    }

    private void init(){
        System.out.println("car ... init");
    }

    private void destory(){
        System.out.println("car ... destory");
    }
}
