package com.example.be.repository;

import com.example.be.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String name);

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Optional<User> findById(String id);
}
