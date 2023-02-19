package com.example.case_study_furama.service.customer;

import com.example.case_study_furama.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> search(String name, String email, String id, Pageable pageable);

    Page<Customer> findAll(Pageable pageable);

    void saveCustomer(Customer customer);

    void remove(Integer id);
}
