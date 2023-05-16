package com.example.case_study_furama.repository.customer;

import com.example.case_study_furama.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select * from customer where is_delete =false and name like concat('%',:name,'%') and email like concat('%',:email,'%')" +
            "and customer_type_id like concat('%',:id,'%') "
            ,nativeQuery = true)
    Page<Customer> searchAndDisplay(@Param("name") String name,@Param("email") String email,@Param("id") String id,Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "update customer set is_delete = true where id = :id",nativeQuery = true)
    void remove(@Param("id") Integer id);

}
