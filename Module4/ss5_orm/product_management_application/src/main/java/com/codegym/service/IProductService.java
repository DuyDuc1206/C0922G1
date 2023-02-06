package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(int id);
    void create(Product product);
    void remove(int id);
    void edit(Product product);
    List<Product> findByName(String name);
}
