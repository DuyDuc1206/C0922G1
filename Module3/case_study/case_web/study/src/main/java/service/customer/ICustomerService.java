package service.customer;

import model.customer.Customer;

import java.util.List;
import java.util.Map;

public interface ICustomerService {
    List<Customer> selectAllCustomer();
    Customer selectCustomerById(int id);
    List<Customer> selectCustomerByCondition(String name,String address);
    Map<String,String> insertCustomer(Customer customer);
    boolean updateCustomer(Customer customer);
    boolean deleteCustomer(int id);
}
