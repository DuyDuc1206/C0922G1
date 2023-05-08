package com.example.be.service;

import com.example.be.dto.ICart;
import com.example.be.model.Cart;
import com.example.be.model.Course;
import com.example.be.model.User;

import java.util.List;

public interface ICartService {
    List<ICart> findCartByUserId(Integer idUser);
    List<Cart> findAll();
    void save(Cart cart);
    void save2(Cart cart);
    void deleteAllByUser(User user);
    Cart findById(Integer id);
    List<Cart> getAllByUser(User user);
    Cart findByCourseAndUser(Course course, User user);
    Boolean existsByCourseAndUser(Course course,User user);
    void deleteById(Integer id);

    void setFlagDelete(Integer idUser);
}
