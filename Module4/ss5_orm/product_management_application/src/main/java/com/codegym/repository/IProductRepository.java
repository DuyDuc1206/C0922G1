package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    Product findById(int id);
    void create(Product product);
    void remove(int id);
    List<Product> findByName(String name);
}
