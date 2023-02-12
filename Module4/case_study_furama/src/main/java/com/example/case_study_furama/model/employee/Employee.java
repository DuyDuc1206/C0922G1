package com.example.case_study_furama.model.employee;

import com.example.case_study_furama.model.user.UserEmployee;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "nvarchar(45)")
    private String name;

    @Column(columnDefinition = "date")
    private String dateOfBirth;

    @Column(columnDefinition = "nvarchar(45)")
    private String idCard;

    @Column(columnDefinition = "nvarchar(45)")
    private String salary;

    @Column(columnDefinition = "nvarchar(45)")
    private String phoneNumber;

    @Column(columnDefinition = "nvarchar(45)")
    private String email;

    @Column(columnDefinition = "nvarchar(45)")
    private String address;

    @ManyToOne
    private Position position;

    @ManyToOne
    private EducationDegree educationDegree;

    @ManyToOne
    private Division division;

    @OneToOne(mappedBy = "employee")
    private UserEmployee user;


}
