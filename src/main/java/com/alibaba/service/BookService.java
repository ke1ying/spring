package com.alibaba.service;

import javax.annotation.Resource;
import javax.inject.Inject;

import com.alibaba.dao.BookDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author keying
 */
@Service
public class BookService {

    /**
     * @Resource(name = "bookDao2")
     * @Inject
     */
    @Autowired(required = false)
    @Qualifier("bookDao2")
    private BookDao bookDao;

    public void print() {
        System.out.println("BookService注入的bookDao:" + bookDao);
    }

    @Override
    public String toString() {
        return "BookService{" +
            "bookDao=" + bookDao +
            '}';
    }
}
