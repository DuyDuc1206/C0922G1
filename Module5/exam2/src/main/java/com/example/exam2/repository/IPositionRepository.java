package com.example.exam2.repository;
import com.example.exam2.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPositionRepository extends JpaRepository<Position,Integer> {
    @Query(value = "select * from position", nativeQuery = true)
    List<Position> getAll();
}
