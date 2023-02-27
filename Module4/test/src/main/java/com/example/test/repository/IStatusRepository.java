package com.example.test.repository;

import com.example.test.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IStatusRepository extends JpaRepository<Status,Integer> {
}
