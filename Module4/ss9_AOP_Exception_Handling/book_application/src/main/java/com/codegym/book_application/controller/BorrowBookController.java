package com.codegym.book_application.controller;

import com.codegym.book_application.service.IBookService;
import com.codegym.book_application.service.IBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/borrow-book")
public class BorrowBookController {
    @Autowired
    private IBorrowBookService borrowBookService;
    @Autowired
    private IBookService bookService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("borrowBookList", borrowBookService.findAllBorrowBook());
        return "/rent/list";
    }
}
