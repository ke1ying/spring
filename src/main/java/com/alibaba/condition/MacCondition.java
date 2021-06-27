package com.alibaba.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 判断mac
 *
 * @author keying
 * @date 2021/6/27
 */
public class MacCondition implements Condition {
    /**
     *
     * @param context 判断条件使用的上下文
     * @param metadata 注释信息
     * @return
     */
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //1、ioc使用的bean工厂
        ConfigurableListableBeanFactory configurableListableBeanFactory = context.getBeanFactory();
        //2、类的加载器
        ClassLoader classLoader = context.getClassLoader();
        //3、环境
        Environment environment = context.getEnvironment();
        //4、定义bean
        BeanDefinitionRegistry beanDefinitionRegistry = context.getRegistry();

        String name = environment.getProperty("os.name");
        if(name.contains("Mac")){
            return true;
        }
        return false;
    }
}
