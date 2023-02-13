package com.codegym.book_application.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class BorrowBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int code;
    private String author;
    @ManyToMany
    private Set<Book> bookSet;

    public BorrowBook() {
    }

    public BorrowBook(int code, String author) {
        this.code = code;
        this.author = author;
    }

    public BorrowBook(int code, Set<Book> bookSet) {
        this.code = code;
        this.bookSet = bookSet;
    }

    public BorrowBook(int id, int code, Set<Book> bookSet) {
        this.id = id;
        this.code = code;
        this.bookSet = bookSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
