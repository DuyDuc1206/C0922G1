package com.codegym.blog_application.service.impl;

import com.codegym.blog_application.model.Blog;
import com.codegym.blog_application.model.Category;
import com.codegym.blog_application.repository.IBlogRepository;
import com.codegym.blog_application.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public List<Blog> findByNameContaining(String name) {
        return blogRepository.findByNameContaining(name);
    }

    @Override
    public Page<Blog> search(String name, Pageable pageable) {
        return blogRepository.findByNameContaining(name,pageable);
    }

    @Override
    public Page<Blog> findByNameContainingAndCategory(String name, String id, Pageable pageable) {
        return blogRepository.findByNameContainingAndCategory(name,id,pageable);
    }
}
