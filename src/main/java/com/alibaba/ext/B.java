package com.alibaba.ext;

import org.springframework.stereotype.Component;

/**
 * @author keying
 * @date 2021/7/28
 */
@Component
public class B {

    private A a;

    public void setA(A a) {
        this.a = a;
    }
}
