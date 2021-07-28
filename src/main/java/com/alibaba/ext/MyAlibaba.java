package com.alibaba.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Component;

/**
 * @author keying
 * @date 2021/7/20
 */
public class MyAlibaba extends ApplicationContextEvent {
    private ThreadLocal<String> courseThreadLocal = new ThreadLocal<String>();

    /**
     * Create a new ContextStartedEvent.
     *
     * @param source the {@code ApplicationContext} that the event is raised for
     *               (must not be {@code null})
     */
    public MyAlibaba(ApplicationContext source,String id) {
        super(source);
        this.courseThreadLocal.set(id);
    }
    public String getId(){
     return this.courseThreadLocal.get();
    }
    public void remove(){
        this.courseThreadLocal.remove();
    }
}
