package com.codegym.book_application.repository;

import com.codegym.book_application.model.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IBorrowBookRepository extends JpaRepository<BorrowBook,Integer> {

    BorrowBook findBorrowBookByCode(int code);
}
