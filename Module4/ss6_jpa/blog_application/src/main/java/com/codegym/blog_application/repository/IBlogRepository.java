package com.codegym.blog_application.repository;

import com.codegym.blog_application.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    List<Blog> findByNameContaining(String name);

}
