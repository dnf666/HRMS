package com.mis.hrm.web.book.controller;

import com.mis.hrm.book.po.Book;
import com.mis.hrm.book.service.BookService;
import com.mis.hrm.util.model.Demo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.xml.crypto.Data;

import static org.junit.Assert.*;

/**
 * created by dailf on 2018/7/13
 *
 * @author dailf
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-web.xml")
@Slf4j
public class BookControllerTest {
<<<<<<< HEAD
    @Resource
    private BookService bookService;
    @Test
    public void insert(){
        Book demo = Book.builder().build();
        int i = bookService.insert(demo);
        log.info(""+i);
    }
    @Test
    public void select(){
        Book demo = Book.builder().build();
        log.info(demo.toString());
    }
=======

>>>>>>> 188f7fef0fc4a852961bd4a719d5720c88d4de0d
}