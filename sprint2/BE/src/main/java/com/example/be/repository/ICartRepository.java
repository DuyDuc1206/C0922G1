package com.example.be.repository;

import com.example.be.model.Cart;
import com.example.be.model.Course;
import com.example.be.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICartRepository extends JpaRepository<Cart,Integer> {
    List<Cart> getAllByUser(User user);
    Cart findByCourseAndUser(Course course, User user);
    Boolean existsByCourseAndUser(Course course,User user);
}
