package com.alibaba.controlller;

import com.alibaba.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author keying
 * @date 2021/6/24
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    public void print() {
        System.out.println(bookService);
    }
}
