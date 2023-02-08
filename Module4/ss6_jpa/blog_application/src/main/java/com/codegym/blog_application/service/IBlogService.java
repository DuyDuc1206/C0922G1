package com.codegym.blog_application.service;

import com.codegym.blog_application.model.Blog;
import com.codegym.blog_application.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Blog findById(int id);

    //    create and update
    void save(Blog blog);

    void remove(int id);

    //    search
    List<Blog> findByNameContaining(String name);

    Page<Blog> search(String name, Pageable pageable);

    Page<Blog> findByNameContainingAndCategory(String name, Category category, Pageable pageable);
}
