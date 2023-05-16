package com.example.case_study_furama.repository.employee;

import com.example.case_study_furama.model.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDivisionRepository extends JpaRepository<Division,Integer> {
}
