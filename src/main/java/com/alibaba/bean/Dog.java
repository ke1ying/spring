package com.alibaba.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author keying
 * @date 2021/6/28
 */
@Component
public class Dog implements InitializingBean, DisposableBean {

    public Dog(){
        System.out.println("Dog... construct");
    }

    /**
     * 销毁方法
     * @throws Exception
     */
    public void destroy() throws Exception {
        System.out.println("Dog... destory");
    }

    /**
     * 初始化方法
     * @throws Exception
     */
    public void afterPropertiesSet() throws Exception {
        System.out.println("Dog afterPropertiesSet ...");
    }
}
