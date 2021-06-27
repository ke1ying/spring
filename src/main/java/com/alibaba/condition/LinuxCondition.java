package com.alibaba.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 判断linux
 *
 * @author keying
 * @date 2021/6/27
 */
public class LinuxCondition implements Condition {
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //3、环境
        Environment environment = context.getEnvironment();

        String name = environment.getProperty("os.name");
        if(name.contains("Linux")){
            return true;
        }
        return false;
    }
}
