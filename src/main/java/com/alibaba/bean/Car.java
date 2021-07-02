package com.alibaba.bean;

import org.springframework.stereotype.Component;

/**
 * @author keying
 * @date 2021/6/28
 */
@Component
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
