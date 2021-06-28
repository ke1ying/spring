package com.alibaba.selector;

import com.alibaba.bean.RedYellow;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义import
 *
 * @author keying
 * @date 2021/6/28
 */
public class MyImportBeanDefinition implements ImportBeanDefinitionRegistrar {

    /**
     * @param importingClassMetadata 当前类注解信息
     * @param registry               beanDefinition 注册类
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean red = registry.containsBeanDefinition("com.alibaba.bean.Red");
        boolean yellow = registry.containsBeanDefinition("com.alibaba.bean.Yellow");
        if (red && yellow) {
            //自定义bean的类型
            BeanDefinition beanDefinition = new RootBeanDefinition(RedYellow.class);
            //自定义组件名
            registry.registerBeanDefinition("RedYellow", beanDefinition);
        }
    }
}
