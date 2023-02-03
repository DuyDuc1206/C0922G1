package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService {
    private static final Map<Integer, Product> products = new HashMap<>();
    static {
        products.put(1,new Product(1,"Điện thoại",10000000,"mới","Hoang Duong"));
        products.put(2,new Product(2,"Xe",20000000,"cũ","Nguyen Duc"));
        products.put(3,new Product(3,"Tủ lạnh",30000000,"bth","Phu Thanh"));
        products.put(4,new Product(4,"Ti vi",40000000,"To","Tan Truong"));
        products.put(5,new Product(5,"Máy quạt",50000000,"nhỏ","Quang Bang"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void create(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
