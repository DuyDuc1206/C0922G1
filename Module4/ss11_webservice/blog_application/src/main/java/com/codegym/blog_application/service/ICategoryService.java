package com.codegym.blog_application.service;

import com.codegym.blog_application.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAllCategory();
    Category findById(Integer id);
    void saveCategory(Category category);
}
