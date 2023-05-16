package com.example.case_study_furama.service.employee.impl;

import com.example.case_study_furama.model.employee.Position;
import com.example.case_study_furama.repository.employee.IPositionRepository;
import com.example.case_study_furama.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionService implements IPositionService {
    @Autowired
    private IPositionRepository positionRepository;
    @Override
    public List<Position> getAllPosition() {
        return positionRepository.findAll();
    }
}
