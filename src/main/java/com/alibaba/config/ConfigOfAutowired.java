package com.alibaba.config;

import com.alibaba.dao.BookDao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author keying
 * @Autowired Spring 的自动装配：DI依赖注入，各个组件之间的装配赋值，完成对IOC容器里各个对象之间赋值调用。
 * 1)、默认优先[按照类型]去ioc容器中找组件 AnnotationConfigApplicationContext.getBean(BookDao.class);
 * 2)、若此类型在容器中找到两个以上组件，则加载此方法找默认的名称AnnotationConfigApplicationContext.getBean("bookDao");
 * 3)、可以和@Qualifier("组件名")组合使用，直接指定组件名。
 * 4)、默认加载的@Autowired(required=false)必须在容器中存在此组件，不存在则报错，默认为true，也可以指定为required=false，则不会报错。
 * 5)、@Primary注解也可以指定主加载的组件，这时候就默认加载此主键的组件，除非@Qualifier指定其他组件。
 *
 * @Autowired属于Spring规范
 * @Resource (java规范 ， JSR) 和@Inject
 * @Resource：和Autowired是自动装配，默认按组件名称装配，可以指定名称。 @Resource(name = "bookDao2")
 *            不支持@Primary 和 @Autowired(required = false)
 * @Inject: 需要导入javax.inject包，和Autowired一样，没有@Autowired(required=false)
 *
 * 这是由前面学的 AntowiredAnnotationBeanPostProcessor
 */
@Configuration
@ComponentScan(value = {"com.alibaba.controller", "com.alibaba.service", "com.alibaba.dao"})
public class ConfigOfAutowired {

    @Primary
    @Bean("bookDao2")
    public BookDao bookDao() {
        BookDao bookD = new BookDao();
        bookD.setLable("2");
        return bookD;
    }
}
