package com.example.case_study_furama.service.contract.impl;

import com.example.case_study_furama.model.contract.Contract;
import com.example.case_study_furama.repository.contract.IContractRepository;
import com.example.case_study_furama.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;

    public Page<Contract> findAllContract(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }
}
