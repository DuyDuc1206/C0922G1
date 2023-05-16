package com.example.case_study_furama.service.facility.impl;

import com.example.case_study_furama.model.facility.FacilityType;
import com.example.case_study_furama.repository.facility.IFacilityTypeRepository;
import com.example.case_study_furama.service.facility.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FacilityTypeService implements IFacilityTypeService {
    @Autowired
    private IFacilityTypeRepository facilityTypeRepository;
    @Override
    public List<FacilityType> findAllFacilityType() {
        return facilityTypeRepository.findAll();
    }
}
