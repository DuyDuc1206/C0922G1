package com.example.case_study_furama.repository.facility;

import com.example.case_study_furama.model.facility.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentTypeRepository extends JpaRepository<RentType,Integer> {
}
