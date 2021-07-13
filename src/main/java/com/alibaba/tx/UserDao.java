package com.alibaba.tx;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author keying
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void insert() {
        String sql = "insert into user (uid,name,age) values (?,?,?)";
        String name = UUID.randomUUID().toString().substring(0, 3);
        jdbcTemplate.update(sql, "111", name, 12);
        System.out.println("插入完成");
        //当有异常时，事务让整个方法回滚
        int i = 10 / 0;
        try {


        } catch (Exception e) {

        }
    }

}
