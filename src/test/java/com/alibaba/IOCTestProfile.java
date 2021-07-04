package com.alibaba;

import javax.sql.DataSource;

import com.alibaba.bean.Yellow;
import com.alibaba.config.MyConfigProfile;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author keying
 */
public class IOCTestProfile {

    /**
     * 1、默认会加载@Profile("default")，指定组件在哪个环境才会注册到容器中,否则都不会注册到IOC容器。
     * 2、改为加载test数据源：
     * 1）使用命令行参数，在虚拟机参数位子加：-Dspring.profile.active=test
     * 2)使用代码的方式，代码不能用有参构造器加载，从源码可以看到，配置类直接加载，就不能改系统环境里面的值。
     * 用无参构造器refresh（）容器,其实就是源码里的三步，第一步this()无参创建对象，第二部register注册配置类，第三部刷新创建容器。
     * 3)没有配置@Profile的bean，不管在哪个环境都能加载。
     *
     * @Profile可以写在方法上，选择加载指定环境的配置组件。写在配置类上，只有满足当前环境，整个类才会加载。
     */
    @Test
    public void test() {
        //第一步创建applicationContext对象
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
        );
        //第二部设置需要激活的环境
        ConfigurableEnvironment configurableEnvironment = applicationContext.getEnvironment();
        configurableEnvironment.setActiveProfiles("test");
        //第三部注册主配置类
        applicationContext.register(MyConfigProfile.class);
        //第四部刷新启动
        applicationContext.refresh();
        //根据类型获取数据源
        String[] strings = applicationContext.getBeanNamesForType(DataSource.class);
        for (String string : strings) {
            System.out.println(string);
        }

        Yellow yellow = applicationContext.getBean(Yellow.class);
        System.out.println(yellow);
        applicationContext.close();
    }
}
