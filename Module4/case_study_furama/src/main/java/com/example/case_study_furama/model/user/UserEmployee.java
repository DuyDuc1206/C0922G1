package com.example.case_study_furama.model.user;

import com.example.case_study_furama.model.employee.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class UserEmployee {
    @Id
    @Column(columnDefinition = "nvarchar(45)")
    private String username;

    @Column(columnDefinition = "nvarchar(45)")
    private String password;

    @OneToOne(mappedBy = "user")
    private Employee employee;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "User_Role",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roleSet;

    public UserEmployee() {
    }

    public UserEmployee(String username, String password, Employee employee, Set<Role> roleSet) {
        this.username = username;
        this.password = password;
        this.employee = employee;
        this.roleSet = roleSet;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }
}
