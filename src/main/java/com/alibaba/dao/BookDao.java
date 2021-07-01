package com.alibaba.dao;

import org.springframework.stereotype.Repository;

/**
 * @author keying
 * 加载进的ioc容器里的名字：默认首字母小写
 */
@Repository
public class BookDao {

    private String lable = "1";

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    @Override
    public String toString() {
        return "BookDao{" +
            "lable='" + lable + '\'' +
            '}';
    }
}
