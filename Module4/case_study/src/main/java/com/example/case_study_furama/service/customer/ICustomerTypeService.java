package com.example.case_study_furama.service.customer;

import com.example.case_study_furama.model.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAllCustomerType();
}
