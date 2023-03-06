package com.example.test.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Statuzz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "statuzz")
    private Set<QuestionContent> questionContentSet;

    public Statuzz() {
    }

    public Statuzz(Integer id, String name) {
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
}
