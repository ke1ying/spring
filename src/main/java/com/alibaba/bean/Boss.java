package com.alibaba.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author keying
 * 默认加载ioc容器中的组件，容器启动会调用无参构造器创建对象，在进行初始化赋值。
 */
@Component
public class Boss {

    private Car car;

    public Car getCar() {
        return car;
    }

    //@Autowired
    public Boss(@Autowired Car car) {
        System.out.println("构造器用的组件：" + car);
        this.car = car;
    }

    //@Autowired
    public void setCar(Car car) {
        System.out.println("方法上用的组件：" + car);
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
            "car=" + car +
            '}';
    }
}
