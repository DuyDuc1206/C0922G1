package com.example.case_study_furama.service.contract;

import com.example.case_study_furama.dto.AttachFacilityDto;
import com.example.case_study_furama.model.contract.AttachFacility;

import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacilityDto> findByContractId(Integer id);
    List<AttachFacility> findAttachFacility();
}
