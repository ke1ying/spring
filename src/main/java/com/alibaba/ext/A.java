package com.alibaba.ext;

import org.springframework.stereotype.Component;

/**
 * @author keying
 * @date 2021/7/28
 */
@Component
public class A {

    private B b;

    public void setB(B b) {
        this.b = b;
    }
}
