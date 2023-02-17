package com.example.case_study_furama.repository.employee;

import com.example.case_study_furama.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
}
