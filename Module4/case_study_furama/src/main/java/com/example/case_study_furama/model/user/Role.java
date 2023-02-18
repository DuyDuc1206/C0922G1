package com.example.case_study_furama.model.user;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "nvarchar(45)")
    private String name;

    @ManyToMany(mappedBy = "roleSet")
    private Set<UserEmployee> userEmployeeSet;

    public Role() {
    }

    public Role(Integer id, String name, Set<UserEmployee> userEmployeeSet) {
        this.id = id;
        this.name = name;
        this.userEmployeeSet = userEmployeeSet;
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

    public Set<UserEmployee> getUserEmployeeSet() {
        return userEmployeeSet;
    }

    public void setUserEmployeeSet(Set<UserEmployee> userEmployeeSet) {
        this.userEmployeeSet = userEmployeeSet;
    }
}
