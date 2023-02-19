package com.example.case_study_furama.model.customer;

import com.example.case_study_furama.model.contract.Contract;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "nvarchar(45)")
    private String name;

    @Column(columnDefinition = "date")
    private String dateOfBirth;

    private boolean gender;

    @Column(columnDefinition = "nvarchar(45)",unique = true)
    private String idCard;

    @Column(columnDefinition = "nvarchar(45)",unique = true)
    private String phoneNumber;

    @Column(columnDefinition = "nvarchar(45)")
    private String address;

    @Column(columnDefinition = "nvarchar(45)",unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "id")
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer")
    private Set<Contract> contractSet;

    @Column(columnDefinition = "boolean default false")
    private boolean isDelete;

    public Customer() {
    }

    public Customer(Integer id, String name, String dateOfBirth, boolean gender, String idCard, String phoneNumber, String email, String address, CustomerType customerType, Set<Contract> contractSet, boolean isDelete) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
        this.contractSet = contractSet;
        this.isDelete = isDelete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }
}
