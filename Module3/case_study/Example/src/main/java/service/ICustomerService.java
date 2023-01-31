package service;

import model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> selectAllCustomer();
    Customer selectCustomerById(int id);
    boolean updateCustomer(Customer customer);
    boolean insertCustomer(Customer customer);
    boolean deleteCustomer(int id);
    List<Customer> selectCustomerByCondition(String name, String address);
}
