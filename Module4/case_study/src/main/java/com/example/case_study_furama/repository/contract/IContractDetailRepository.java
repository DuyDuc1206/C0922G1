package com.example.case_study_furama.repository.contract;

import com.example.case_study_furama.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractDetailRepository extends JpaRepository<ContractDetail ,Integer> {
}
