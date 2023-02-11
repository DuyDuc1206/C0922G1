package com.example.register.service.impl;

import com.example.register.model.User;
import com.example.register.repository.IUserRepository;
import com.example.register.service.IUserService;
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

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean check(String email) {
        for (User user:userRepository.findAll() ) {
            if (user.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }
}
