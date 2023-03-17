package com.example.exam2.service.impl;

import com.example.exam2.model.CompanyName;
import com.example.exam2.repository.ICompanyNameRepository;
import com.example.exam2.service.ICompanyNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompanyNameService implements ICompanyNameService {
    @Autowired
    private ICompanyNameRepository companyNameRepository;
    @Override
    public List<CompanyName> getAll() {
        return companyNameRepository.getAll();
    }
}
