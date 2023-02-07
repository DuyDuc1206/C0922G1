package com.codegym.blog_application.service;

import com.codegym.blog_application.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Blog findById(int id);

    //    create and update
    void save(Blog blog);

    void remove(int id);

    //    search
    List<Blog> findByNameContaining(String name);

}
