package com.alibaba.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author keying
 * @date 2021/6/28
 */
public class ColorFactoryBean implements FactoryBean<Color> {
    public Color getObject() throws Exception {
        System.out.println("get Object ...");
        return new Color();
    }

    public Class<?> getObjectType() {
        return Color.class;
    }

    /**
     *
     * @return true 单例
     *          false 多例
     */
    public boolean isSingleton() {
        return false;
    }
}
