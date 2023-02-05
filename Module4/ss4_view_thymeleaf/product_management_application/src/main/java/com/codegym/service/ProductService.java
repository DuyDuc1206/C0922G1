package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService {
    private static final List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Điện thoại", 10000000, "mới", "Hoang Duong"));
        products.add(new Product(2, "Xe", 20000000, "cũ", "Nguyen Duc"));
        products.add(new Product(3, "Tủ lạnh", 30000000, "bth", "Phu Thanh"));
        products.add(new Product(4, "Ti vi", 40000000, "To", "Tan Truong"));
        products.add(new Product(5, "Máy quạt", 50000000, "nhỏ", "Quang Bang"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(int id) {
        return products.get(id - 1);
    }

    @Override
    public void create(Product product) {
        products.add(product);
    }

    @Override
    public void update(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == product.getId()) {
                products.set(i, product);
            }
        }
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
