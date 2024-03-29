package com.example.case_study_furama.service.facility.impl;

import com.example.case_study_furama.model.facility.RentType;
import com.example.case_study_furama.repository.facility.IRentTypeRepository;
import com.example.case_study_furama.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private IRentTypeRepository rentTypeRepository;
    @Override
    public List<RentType> findAllRentType() {
        return rentTypeRepository.findAll();
    }
}
