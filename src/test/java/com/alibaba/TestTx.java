package com.alibaba;

import com.alibaba.tx.TxConfig;
import com.alibaba.tx.UserService;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author keying
 */
public class TestTx {

    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = applicationContext.getBean(UserService.class);
        userService.inert();

        applicationContext.close();
    }
}
