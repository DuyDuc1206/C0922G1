package com.codegym.book_application.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

@Component
@Aspect
public class Borrow {
    static int count1 = 0;
    static int count2 = 0;

    @Pointcut("within( com.codegym.book_application.controller.BookController)")
    public void getAll() {
    }

    @After(value = "getAll()")
    public void print() {
        count1++;
        System.out.printf("Số lần truy cập thư viện: " + count1)
        ;
    }

    @Pointcut("execution(* com.codegym.book_application.controller.BookController.rentBook(..))" +
            "||execution(* com.codegym.book_application.controller.BookController.deleteBorrowBook(..))")
    public void getAll1() {
    }

    @After(value = "getAll1()")
    public void print1() {
        count2++;
        System.out.printf("Số lần thay đổi sách: "+ count2);
    }

}
