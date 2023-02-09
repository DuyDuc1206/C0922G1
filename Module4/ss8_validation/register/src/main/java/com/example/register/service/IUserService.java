package com.example.register.service;

import com.example.register.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    void save(User user);
}
