package com.example.case_study_furama.dto;

import com.example.case_study_furama.model.contract.Contract;
import com.example.case_study_furama.model.employee.Division;
import com.example.case_study_furama.model.employee.EducationDegree;
import com.example.case_study_furama.model.employee.Position;
import com.example.case_study_furama.model.user.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class EmployeeDto implements Validator {
    private Integer id;
    @NotEmpty(message = "Not null")
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$",message = "First letter must be capitalized,name must not contain number")
    private String name;

    @NotEmpty(message = "Not empty")
    private String dateOfBirth;

    @NotEmpty(message = "Not Empty")
    @Pattern(regexp = "^\\p{N}{9,12}$",message = "Id card must be 9 or 12 digits")
    private String idCard;

    @NotNull(message = "Not null")
    @Min(value = 0,message = "Salary must be greater than 0 ")
    private Double salary;

    @NotEmpty(message = "Not Empty")
    @Pattern(regexp = "^(090|091|\\+8490|\\+8491)\\d{7}$",message = "{error phone number. ex 090 | 091 XXXXXXX}")
    private String phoneNumber;

    @NotEmpty(message = "Not empty")
    @Pattern(regexp = "^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",message = "{error email. ex: duyduc@gmail.com")
    private String email;

    @NotEmpty(message = "Not Empty")
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

    private boolean isDelete;

    public EmployeeDto() {
    }

    public EmployeeDto(Integer id, String name, String dateOfBirth, String idCard, Double salary, String phoneNumber, String email, String address, Position position, EducationDegree educationDegree, Division division,  User user, boolean isDelete) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
