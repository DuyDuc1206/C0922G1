package com.codegym.book_application.service;

import com.codegym.book_application.model.BorrowBook;

import java.util.List;

public interface IBorrowBookService {
    List<BorrowBook> findAllBorrowBook();
    BorrowBook findById(int id);
    void save(BorrowBook borrowBook);
    void delete(int id);
    BorrowBook findByCode(int code);
}
