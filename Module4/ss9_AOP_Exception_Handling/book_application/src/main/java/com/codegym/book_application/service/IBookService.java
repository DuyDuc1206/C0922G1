package com.codegym.book_application.service;

import com.codegym.book_application.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAllBook();
    Book findById(int id);
    void save(Book book);

}
