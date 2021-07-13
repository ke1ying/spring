package com.alibaba.tx;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author keying
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void inert(){
        userDao.insert();
    }

}
