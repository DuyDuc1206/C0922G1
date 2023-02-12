package com.example.case_study_furama.model.user;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "nvarchar(45)")
    private String name;

    @ManyToMany(mappedBy = "roleSet")
    private Set<UserEmployee> userEmployeeSet;

}
