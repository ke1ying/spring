package com.alibaba.ext;

import com.alibaba.bean.Dog;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author keying
 */
@Component
public class MyBeanDefinitionRegisterPostProcessor implements BeanDefinitionRegistryPostProcessor {
    /**
     * beanFactory里的bean创建，就是按照BeanDefinitionRegistry定义的bean信息创建的
     * @param registry
     * @throws BeansException
     */
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        int count = registry.getBeanDefinitionCount();
        System.out.println("当前beanDefinitionRegistry几个 bean:" + count);
        String beanName = "registerBean";
        //下面两个方法效果都是一样的：注册一个bean
        //RootBeanDefinition rootBeanDefinition =  new RootBeanDefinition(Dog.class);
        AbstractBeanDefinition rootBeanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Dog.class).getBeanDefinition();
        registry.registerBeanDefinition(beanName, rootBeanDefinition);
    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        int count = beanFactory.getBeanDefinitionCount();
        System.out.println("beanDefinitionRegistry当前beanFactory几个 bean:" + count);
    }
}
