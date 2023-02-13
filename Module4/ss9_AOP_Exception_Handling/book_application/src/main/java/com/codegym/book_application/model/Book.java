package com.codegym.book_application.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String author;
    private int quantityAvailable;
    private int amount;

    @ManyToMany(mappedBy = "bookSet")
    private Set<BorrowBook> borrowBookSet;


    public Book() {
    }

    public Book(int id, String name, String author, int quantityAvailable, int amount, Set<BorrowBook> borrowBookSet) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.quantityAvailable = quantityAvailable;
        this.amount = amount;
        this.borrowBookSet = borrowBookSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public Set<BorrowBook> getBorrowBookSet() {
        return borrowBookSet;
    }

    public void setBorrowBookSet(Set<BorrowBook> borrowBookSet) {
        this.borrowBookSet = borrowBookSet;
    }
}
