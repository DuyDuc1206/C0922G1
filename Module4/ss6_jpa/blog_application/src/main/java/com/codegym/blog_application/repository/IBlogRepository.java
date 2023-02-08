package com.codegym.blog_application.repository;

import com.codegym.blog_application.model.Blog;
import com.codegym.blog_application.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByNameContaining(String name);

    //    Phân trang (list + search)
    Page<Blog> findByNameContaining(String name, Pageable pageable);

    Page<Blog> findByNameContainingAndCategory(String name, Category category, Pageable pageable);


    //    Phân trang (list)
    Page<Blog> findAll(Pageable pageable);
}
