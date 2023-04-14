package com.example.exam2.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String code;
    @ManyToOne
    private TypeCoach typeCoach;

    @ManyToOne
    private CompanyName companyName;

    @ManyToOne
    private Position startLocation;

    @ManyToOne
    private Position destination;
    private String phoneNumber;
    private String email;
    private String startTime;
    private String endTime;

}
