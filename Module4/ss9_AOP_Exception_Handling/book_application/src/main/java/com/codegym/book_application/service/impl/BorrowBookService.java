package com.codegym.book_application.service.impl;

import com.codegym.book_application.model.BorrowBook;
import com.codegym.book_application.repository.IBorrowBookRepository;
import com.codegym.book_application.service.IBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowBookService implements IBorrowBookService {
    @Autowired
    private IBorrowBookRepository borrowBookRepository;


    @Override
    public List<BorrowBook> findAllBorrowBook() {
        return borrowBookRepository.findAll();
    }

    @Override
    public BorrowBook findById(int id) {
        return borrowBookRepository.findById(id).orElse(null);
    }

    @Override
    public void save(BorrowBook borrowBook) {
        borrowBookRepository.save(borrowBook);
    }

    @Override
    public void delete(int id) {
        borrowBookRepository.deleteById(id);
    }

    @Override
    public BorrowBook findByCode(int code) {
        return borrowBookRepository.findBorrowBookByCode(code);
    }

}
