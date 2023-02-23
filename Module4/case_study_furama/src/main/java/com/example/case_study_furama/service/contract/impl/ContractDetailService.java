package com.example.case_study_furama.service.contract.impl;

import com.example.case_study_furama.model.contract.ContractDetail;
import com.example.case_study_furama.repository.contract.IContractDetailRepository;
import com.example.case_study_furama.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository contractDetailRepository;
    @Override
    public void saveContractDetail(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }
}
