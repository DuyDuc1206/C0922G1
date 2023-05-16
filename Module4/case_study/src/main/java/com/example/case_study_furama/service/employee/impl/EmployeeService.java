package com.example.case_study_furama.service.employee.impl;

import com.example.case_study_furama.model.employee.Employee;
import com.example.case_study_furama.repository.employee.IEmployeeRepository;
import com.example.case_study_furama.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Page<Employee> getAllEmployee(String name, String positionId, String degreeId, Pageable pageable) {
        return employeeRepository.searchAndDisplay(name, positionId, degreeId, pageable);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteEmployee(id);
    }

    @Override
    public Page<Employee> getAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }
}
