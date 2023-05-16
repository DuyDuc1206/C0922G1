package com.example.case_study_furama.service.contract;

import com.example.case_study_furama.dto.IContractDto;
import com.example.case_study_furama.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Page<Contract> findAllContract(Pageable pageable);

    Page<IContractDto> findTotal(Pageable pageable);

    void saveContract(Contract contract);

}
