package com.example.case_study_furama.service.customer.impl;

import com.example.case_study_furama.model.customer.CustomerType;
import com.example.case_study_furama.repository.customer.ICustomerTypeRepository;
import com.example.case_study_furama.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAllCustomerType() {
        return customerTypeRepository.findAll();
    }
}
