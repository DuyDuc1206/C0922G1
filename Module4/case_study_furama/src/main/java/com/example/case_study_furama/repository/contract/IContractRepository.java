package com.example.case_study_furama.repository.contract;

import com.example.case_study_furama.model.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractRepository extends JpaRepository<Contract,Integer> {
}
