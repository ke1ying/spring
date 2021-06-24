package com.alibaba.config;

import com.alibaba.bean.Person;
import com.alibaba.filter.MyTypeFilter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Scope;

/**
 * @Scope
 * prototype : 多实例，每次获取bean的时候，才会创建对象
 * singleton （默认的）: 单实例，创建容器的时候直接把bean交给springIOC容器管理，
 *                     以后每次直接在IOC容器中get
 *
 * @author keying
 * @date 2021/6/24
 */
@Configuration
public class BeanConfig2 {

    @Scope("prototype")
    @Bean(value = "person2")
    public Person getPerson(){
        System.out.println("把bean交给容器管理");
        return new Person("person2",19);
    }
}
