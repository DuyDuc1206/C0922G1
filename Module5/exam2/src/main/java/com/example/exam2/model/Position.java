package com.example.exam2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "startLocation")
    @JsonBackReference
    private Set<Coach> coachSet1;
    @OneToMany(mappedBy = "destination")
    @JsonBackReference
    private Set<Coach> coachSet2;

    public Position() {
    }

    public Position(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public Set<Coach> getCoachSet1() {
        return coachSet1;
    }

    public void setCoachSet1(Set<Coach> coachSet1) {
        this.coachSet1 = coachSet1;
    }

    public Set<Coach> getCoachSet2() {
        return coachSet2;
    }

    public void setCoachSet2(Set<Coach> coachSet2) {
        this.coachSet2 = coachSet2;
    }
}
