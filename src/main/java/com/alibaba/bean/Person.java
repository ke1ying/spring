package com.alibaba.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * 人
 *
 * @author keying
 * @date 2021/6/24
 */
public class Person {

    /**
     * @Value ：1、普通赋值
     *          2、#{}计算复制
     *          3、&{}加载配置文件，也就是运行环境里面的值
     */
    @Value("张三")
    private String name;

    @Value("${value.name}")
    private String getProperties;

    @Value("#{100-50}")
    private Integer age;

    @Override
    public String toString() {
        return "Person{" +
            "name='" + name + '\'' +
            ", getProperties='" + getProperties + '\'' +
            ", age=" + age +
            '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGetProperties() {
        return getProperties;
    }

    public void setGetProperties(String getProperties) {
        this.getProperties = getProperties;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person() {
    }

    public Person(String name, String getProperties, Integer age) {
        this.name = name;
        this.getProperties = getProperties;
        this.age = age;
    }


    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
