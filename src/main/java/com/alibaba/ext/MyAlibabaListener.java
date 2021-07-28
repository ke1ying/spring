package com.alibaba.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author keying
 * @date 2021/7/26
 */
@Component
public class MyAlibabaListener {

    @EventListener(value = MyAlibaba.class)
    public void onApplicationEvent(MyAlibaba event) {
        System.out.println("获取到："+event.getId());
    }
}
