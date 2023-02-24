package com.example.case_study_furama.repository.employee;

import com.example.case_study_furama.model.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository extends JpaRepository<Position,Integer> {
}
