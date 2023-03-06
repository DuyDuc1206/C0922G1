package com.example.test.repository;

import com.example.test.model.Statuzz;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IStatusRepository extends JpaRepository<Statuzz,Integer> {
}
