package com.example.case_study_furama.repository.customer;

import com.example.case_study_furama.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select * from customer where ( customer.name like concat('%',:name,'%') " +
            "and customer.gender like concat('%',:email,'%') " +
            "and customer.customer_type_id like concat('%',:id,'%'))", nativeQuery = true)
    Page<Customer> findByNameAndByEmailAndCustomerType(@Param("name") String name, @Param("email") String gender, @Param("id") String id, Pageable pageable);
}
