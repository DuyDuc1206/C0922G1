package com.example.case_study_furama.model.user;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "nvarchar(45)",unique = true)
    private String name;

    @ManyToMany(mappedBy = "roleSet")
    private Set<User> userSet;

    public Role() {
    }

    public Role(Integer id, String name, Set<User> userSet) {
        this.id = id;
        this.name = name;
        this.userSet = userSet;
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

    public Set<User> getUserEmployeeSet() {
        return userSet;
    }

    public void setUserEmployeeSet(Set<User> userSet) {
        this.userSet = userSet;
    }
}
