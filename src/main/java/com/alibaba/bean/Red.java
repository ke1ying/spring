package com.alibaba.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * red
 *
 * @author keying
 *
 * Aware能把spring底层组件传入自定义的bean中，
 * 比如beanNameAware和ApplicationContextAware都是由xxxProcess(如：ApplicationContextAwareProcessor)
 * ApplicationContextAwareProcessor后置处理器，创建完bean之后，就吧相关的组件传入自定义组件中
 */
@Component
public class Red implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware , InitializingBean,
    DisposableBean {

    private ApplicationContext applicationContext;
    private String computer;

    public Red(){
        System.out.println("red ... Coustruct");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("spring底层传入自定义组件的容器：" + applicationContext);
        this.applicationContext = applicationContext;
    }

    public void setBeanName(String name) {
        System.out.println("实现beanNameAware获取当前bean的name:" + name);
    }

    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        String string = resolver.resolveStringValue("此电脑是：${os.name},生产时间：#{2021-3}");
        this.computer = string;
        System.out.println("embeddedValueResolver:" + string);
    }

    public void destroy() throws Exception {
        System.out.println("red .. destroy");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("red ... afterPropertiesSet");
    }
}
