package com.example.exam2.repository;

import com.example.exam2.model.CompanyName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICompanyNameRepository extends JpaRepository<CompanyName,Integer> {
    @Query(value = "select * from company_name", nativeQuery = true)
    List<CompanyName> getAll();
}
