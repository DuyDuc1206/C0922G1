package com.example.case_study_furama.service.facility.impl;

import com.example.case_study_furama.model.facility.Facility;
import com.example.case_study_furama.repository.facility.IFacilityRepository;
import com.example.case_study_furama.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public Page<Facility> searchAndDisplay(String name, String facilityType, Pageable pageable) {
        return facilityRepository.searchAndDisplay(name,facilityType,pageable);
    }
}
