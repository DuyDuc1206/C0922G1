package com.codegym.book_application.controller;

import com.codegym.book_application.model.Book;
import com.codegym.book_application.model.BorrowBook;
import com.codegym.book_application.service.IBookService;
import com.codegym.book_application.service.IBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Random;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IBorrowBookService borrowBookService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("bookList", bookService.findAllBook());
        return "/list";
    }

    @GetMapping("/edit-form")
    public String editForm(int id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "/edit";
    }

    @PostMapping("/rent")
    public String rentBook(@ModelAttribute Book book) {
        if (book.getQuantityAvailable()==0){
            return "error";
        }
        book.setQuantityAvailable(book.getQuantityAvailable() - 1);
        bookService.save(book);
        Random random = new Random();
        int code = random.nextInt(99999 - 10000 + 1) + 10000;
        BorrowBook borrowBook = new BorrowBook(code, book.getAuthor());
        borrowBookService.save(borrowBook);

        if (book.getBorrowBookSet() == null) {
            book.setBorrowBookSet(new HashSet<>());
        }
        book.getBorrowBookSet().add(borrowBook);
        if (borrowBook.getBookSet() == null) {
            borrowBook.setBookSet(new HashSet<>());
        }
        borrowBook.getBookSet().add(book);
        bookService.save(book);
        borrowBookService.save(borrowBook);

        return "redirect:/book";
    }

    @PostMapping("/delete")
    public String deleteBorrowBook(int code, @ModelAttribute Book book, @ModelAttribute BorrowBook borrowBook) {
        BorrowBook oldBorrowBook = borrowBookService.findByCode(code);

        Book oldBook = oldBorrowBook.getBookSet().stream().findFirst().get();

        oldBook.setQuantityAvailable(oldBook.getQuantityAvailable() + 1);

        oldBook.getBorrowBookSet().removeIf(br -> br.getId() == oldBorrowBook.getId());
        oldBorrowBook.getBookSet().removeIf(e -> e.getId() == book.getId());

        borrowBookService.delete(oldBorrowBook.getId());

        bookService.save(oldBook);
        return "redirect:/borrow-book/";
    }
}
