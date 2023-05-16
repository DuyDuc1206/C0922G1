package service.customer.impl;

import model.customer.Customer;
import repository.customer.ICustomerRepository;
import repository.customer.impl.CustomerRepository;
import service.customer.ICustomerService;
import validation.RegexCheck;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService {
    private ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> selectAllCustomer() {
        return customerRepository.selectAllCustomer();
    }

    @Override
    public Customer selectCustomerById(int id) {
        return customerRepository.selectCustomerById(id);
    }

    @Override
    public List<Customer> selectCustomerByCondition(String name, String address) {
        return customerRepository.selectCustomerByCondition(name, address);
    }


    @Override
    public Map<String, String> insertCustomer(Customer customer) {
        Map<String, String> errorMap = new HashMap<>();
        if ("".equals(customer.getCustomerName())) {
            errorMap.put("name", "Name is required");
        } else if (!RegexCheck.checkName(customer.getCustomerName())) {
            errorMap.put("name", "Name doesn't match");
        }
        if ("".equals(customer.getEmail())) {
            errorMap.put("email", "Email is required");
        } else if (!RegexCheck.checkEmail(customer.getEmail())) {
            errorMap.put("email", "Email doesn't match");
        }
        if ("".equals(customer.getPhoneNumber())) {
            errorMap.put("phoneNumber", "Phone number is required");
        } else if (!RegexCheck.checkPhoneNumber(customer.getPhoneNumber())) {
            errorMap.put("phoneNumber", "Phone number doesn't match");
        }
        if ("".equals(customer.getAddress())){
            errorMap.put("address","Address is required");
        }
        if ("".equals(customer.getIdCard())) {
            errorMap.put("idCard", "Id Card is required");
        } else if (!RegexCheck.checkIdCard(customer.getIdCard())) {
            errorMap.put("idCard", "Id card doesn't match");
        }
        if("".equals(customer.getDateOfBirth())){
            errorMap.put("birthday","Birthday is required");
        }
        if("".equals(customer.isGender())){
            errorMap.put("gender","Gender is required");
        }
        if ("".equals(customer.getCustomerTypeName())){
            errorMap.put("customerType","Customer Name is required");
        }
        if(errorMap.isEmpty()){
            customerRepository.insertCustomer(customer);
        }
        return errorMap;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return customerRepository.updateCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(int id) {
        return customerRepository.deleteCustomer(id);
    }
}
