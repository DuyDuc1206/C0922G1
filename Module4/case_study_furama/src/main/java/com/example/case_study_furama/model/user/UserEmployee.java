package com.example.case_study_furama.model.user;

import com.example.case_study_furama.model.employee.Employee;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEmployee {
    @Id
    @Column(columnDefinition = "nvarchar(45)")
    private String username;

    @Column(columnDefinition = "nvarchar(45)")
    private String password;

    @OneToOne
    private Employee employee;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "User_Role",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roleSet;
}
