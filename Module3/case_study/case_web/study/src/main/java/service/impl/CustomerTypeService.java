package service.impl;

import model.CustomerType;
import repository.ICustomerTypeRepository;
import repository.impl.CustomerTypeRepository;

import java.util.List;

public class CustomerTypeService {
    ICustomerTypeRepository customerTypeRepository = new CustomerTypeRepository();
    public List<CustomerType> selectAllCustomerType() {
        return customerTypeRepository.selectAllCustomerType();
    }
}
