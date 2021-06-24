package com.alibaba.config;

import com.alibaba.bean.Person;
import com.alibaba.filter.MyTypeFilter;
import com.alibaba.service.BookService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * 配置文件
 * @Configuration 告诉spring这是一个配置类
 *
 * @ComponentScan 扫描路径配置
 * excludeFilters：指定排除扫描的包 ，按照特定的规则排除
 * includeFilters：指定要扫描的包 , useDefaultFilters：默认是true，默认扫描所有包，设置成false
 * jdk1.8中 新增 Repeatable，ComponentScan是一个重复注解，可以用ComponentScans注解
 * FilterType.ANNOTATION ：注解名规则
 * FilterType.ASSIGNABLE_TYPE : 按照给定的类型
 * FilterType.ASPECTJ ：使用aspectj表达式
 * FilterType.REGEX ：使用正则指定
 * FilterType.CUSTOM ：自定义
 *
 * @author keying
 * @date 2021/6/24
 */
@Configuration
@ComponentScans(value = {
    @ComponentScan(value = "com.alibaba", includeFilters = {
        /*@Filter(type = FilterType.ANNOTATION,classes = {Controller.class}),
        @Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookService.class})*/
        @Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
    },useDefaultFilters = false)
})
public class BeanConfig {

    /**
     * @Bean吧对象注入给spring容器
     * 1、id默认是方法名，value方法可以指定方法名
     * @return Person
     */
    @Bean(value = "person")
    public Person getPerson(){
        return new Person("李四",19);
    }
}
