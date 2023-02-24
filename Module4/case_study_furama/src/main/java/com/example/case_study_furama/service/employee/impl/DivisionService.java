package com.example.case_study_furama.service.employee.impl;

import com.example.case_study_furama.model.employee.Division;
import com.example.case_study_furama.repository.employee.IDivisionRepository;
import com.example.case_study_furama.service.employee.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisionService {
    @Autowired
    private IDivisionRepository divisionRepository;
    @Override
    public List<Division> getAllDivision() {
        return divisionRepository.findAll();
    }
}
