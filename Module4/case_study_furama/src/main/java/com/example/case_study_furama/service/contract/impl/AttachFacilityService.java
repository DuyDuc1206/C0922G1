package com.example.case_study_furama.service.contract.impl;

import com.example.case_study_furama.dto.AttachFacilityDto;
import com.example.case_study_furama.model.contract.AttachFacility;
import com.example.case_study_furama.repository.contract.IAttachFacilityRepository;
import com.example.case_study_furama.service.contract.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements IAttachFacilityService {

    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;


    @Override
    public List<AttachFacilityDto> findByContractId(Integer id) {
        return attachFacilityRepository.findAttachFacility(id);
    }

    @Override
    public List<AttachFacility> findAttachFacility() {
        return attachFacilityRepository.findAll();
    }

}
