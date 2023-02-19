package com.example.case_study_furama.model.employee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "nvarchar(45)",unique = true)
    private String name;

    @OneToMany(mappedBy = "educationDegree")
    private Set<Employee> employeeSet;

    public EducationDegree() {
    }

    public EducationDegree(Integer id, String name, Set<Employee> employeeSet) {
        this.id = id;
        this.name = name;
        this.employeeSet = employeeSet;
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

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }
}
