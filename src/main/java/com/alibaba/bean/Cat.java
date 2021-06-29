package com.alibaba.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

/**
 * @author keying
 * @date 2021/6/28
 */
@Component
public class Cat {

    public Cat(){
        System.out.println("Cat...construct");
    }

    /**
     * construct 构造函数创建对象之后执行
     */
    @PostConstruct
    public void init(){
        System.out.println("cat ...PostConstruct.");
    }

    /**
     * 销毁之前调用
     */
    @PreDestroy
    public void destory(){
        System.out.println("cat ...PreDestroy");
    }
}
