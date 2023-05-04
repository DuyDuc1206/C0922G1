package com.example.be.service.impl;

import com.example.be.model.Cart;
import com.example.be.model.Course;
import com.example.be.model.User;
import com.example.be.repository.ICartRepository;
import com.example.be.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService {
    @Autowired
    private ICartRepository cartRepository;

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Boolean existsByCourseAndUser(Course course, User user) {
        return cartRepository.existsByCourseAndUser(course, user);
    }

    @Override
    public void save(Cart cart) {
        if (existsByCourseAndUser(cart.getCourse(), cart.getUser())) {
            Cart cart1 = cartRepository.findByCourseAndUser(cart.getCourse(), cart.getUser());
            int quantity = cart1.getQuantity();
            cart1.setQuantity(quantity += 1);
            cartRepository.save(cart1);
        } else {
            cartRepository.save(cart);
        }
    }

    @Override
    public void save2(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public void deleteAllByUser(User user) {

    }

    @Override
    public Cart findById(Integer id) {
        return cartRepository.findById(id).orElse(null);
    }

    @Override
    public List<Cart> getAllByUser(User user) {
        return cartRepository.getAllByUser(user);
    }

    @Override
    public Cart findByCourseAndUser(Course course, User user) {
        return cartRepository.findByCourseAndUser(course, user);
    }

    @Override
    public void deleteById(Integer id) {
        cartRepository.deleteById(id);
    }
}
