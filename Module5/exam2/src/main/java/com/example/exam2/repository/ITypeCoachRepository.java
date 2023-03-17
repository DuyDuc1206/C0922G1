package com.example.exam2.repository;

import com.example.exam2.model.TypeCoach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITypeCoachRepository extends JpaRepository<TypeCoach,Integer> {
    @Query(value = "select * from type_coach", nativeQuery = true)
    List<TypeCoach> getAll();
}
