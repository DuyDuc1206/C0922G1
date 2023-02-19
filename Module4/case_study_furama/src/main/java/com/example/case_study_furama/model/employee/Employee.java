package com.example.case_study_furama.model.employee;

import com.example.case_study_furama.model.contract.Contract;
import com.example.case_study_furama.model.user.User;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "nvarchar(45)")
    private String name;

    @Column(columnDefinition = "date")
    private String dateOfBirth;

    @Column(columnDefinition = "nvarchar(45) ",unique = true)
    private String idCard;

    @Column(columnDefinition = "double")
    private Double salary;

    @Column(columnDefinition = "nvarchar(45)",unique = true)
    private String phoneNumber;

    @Column(columnDefinition = "nvarchar(45)",unique = true)
    private String email;

    @Column(columnDefinition = "nvarchar(45)")
    private String address;

    @ManyToOne
    @JoinColumn(name = "position_id",referencedColumnName = "id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_degree_id",referencedColumnName = "id")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "division",referencedColumnName = "id")
    private Division division;

    @OneToMany(mappedBy = "employee")
    private Set<Contract> contractSet;

    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "username")
    private User user;

    @Column(columnDefinition = "boolean default false")
    private boolean isDelete;

    public Employee() {
    }

    public Employee(Integer id, String name, String dateOfBirth, String idCard, Double salary, String phoneNumber, String email, String address, Position position, EducationDegree educationDegree, Division division, Set<Contract> contractSet, User user, boolean isDelete) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.contractSet = contractSet;
        this.user = user;
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
