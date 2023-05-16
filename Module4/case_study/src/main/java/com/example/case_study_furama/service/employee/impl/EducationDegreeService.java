package com.example.case_study_furama.service.employee.impl;

import com.example.case_study_furama.model.employee.EducationDegree;
import com.example.case_study_furama.repository.employee.IEducationDegreeRepository;
import com.example.case_study_furama.service.employee.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeService implements IEducationDegreeService {
    @Autowired
    private IEducationDegreeRepository educationDegreeRepository;

    @Override
    public List<EducationDegree> getAllEducationDegree() {
        return educationDegreeRepository.findAll();
    }
}
