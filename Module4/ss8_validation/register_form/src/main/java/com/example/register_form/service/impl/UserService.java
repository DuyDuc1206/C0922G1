package com.example.register_form.service.impl;

import com.example.register_form.model.User;
import com.example.register_form.repository.IUserRepository;
import com.example.register_form.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
