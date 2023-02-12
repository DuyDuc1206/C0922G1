package com.example.case_study_furama.model.customer;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "nvarchar(45)")
    private String name;

    @Column(columnDefinition = "date")
    private String dateOfBirth;

    private boolean gender;

    @Column(columnDefinition = "nvarchar(45)")
    private String idCard;

    @Column(columnDefinition = "nvarchar(45)")
    private String phoneNumber;

    @Column(columnDefinition = "nvarchar(45)")
    private String email;

    @Column(columnDefinition = "nvarchar(45)")
    private String address;

    @ManyToOne
    private CustomerType customerType;

}
