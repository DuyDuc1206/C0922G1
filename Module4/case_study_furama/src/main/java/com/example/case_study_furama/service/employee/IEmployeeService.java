package com.example.case_study_furama.service.employee;

import com.example.case_study_furama.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> getAllEmployee(String name, String positionId, String degreeId, Pageable pageable);

    void deleteEmployee(Integer id);

    Page<Employee> getAll(Pageable pageable);

    void saveEmployee(Employee employee);

    Employee findById(Integer id);
}
