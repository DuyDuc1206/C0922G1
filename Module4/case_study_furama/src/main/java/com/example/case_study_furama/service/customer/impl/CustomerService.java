package com.example.case_study_furama.service.customer.impl;

import com.example.case_study_furama.model.customer.Customer;
import com.example.case_study_furama.repository.customer.ICustomerRepository;
import com.example.case_study_furama.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> getAllCustomer(String name, String gender, String id, Pageable pageable) {
        return customerRepository.findByNameAndByGenderAndCustomerType(name,gender,id,pageable);
    }
}
