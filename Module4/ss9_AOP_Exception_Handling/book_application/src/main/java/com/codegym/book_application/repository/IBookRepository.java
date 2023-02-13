package com.codegym.book_application.repository;

import com.codegym.book_application.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book,Integer> {
}
