package com.example.case_study_furama.service.facility;

import com.example.case_study_furama.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService {
    Page<Facility> searchAndDisplay(String name, String facilityType, Pageable pageable);
}
