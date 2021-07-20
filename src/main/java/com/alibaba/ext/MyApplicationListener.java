package com.alibaba.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author keying
 */
@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {

    /**
     * 当容器中发布此事件，方法会得到触发
     *
     * @param event
     */
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("收到的事件：" + event);
    }
}
