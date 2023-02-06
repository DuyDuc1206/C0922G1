package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        List<Product> productList = null;
        productList = entityManager.createQuery("select p from Product as p").getResultList();
        return productList;
    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class,id);
    }

    @Override
    public void create(Product product) {
        entityManager.persist(product);
    }

    @Override
    public void remove(int id) {
        Product product = findById(id);
        if (product != null){
            entityManager.remove(product);
        }
    }

    @Override
    public List<Product> findByName(String name) {
       List<Product> productList = new ArrayList<>();
        for (Product p: findAll()) {
            if (p.getName().contains(name)){
                productList.add(p);
            }
        }
        return productList;
    }
}
