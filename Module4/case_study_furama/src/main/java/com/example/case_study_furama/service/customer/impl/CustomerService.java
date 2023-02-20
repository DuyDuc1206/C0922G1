package com.example.case_study_furama.service.customer.impl;

import com.example.case_study_furama.model.customer.Customer;
import com.example.case_study_furama.repository.customer.ICustomerRepository;
import com.example.case_study_furama.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> search(String name, String email, String id, Pageable pageable) {
        return customerRepository.searchAndDisplay(name,email,id,pageable);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public boolean saveCustomer(Customer customer) {
        if (customerRepository.findById(customer.getId()).isPresent()) {
            return false;
        }
        try {
            customerRepository.save(customer);
        } catch (DataIntegrityViolationException e) {
            return false;
        }
        return true;
    }

    @Override
    public void remove(Integer id) {
        customerRepository.remove(id);
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }


}
