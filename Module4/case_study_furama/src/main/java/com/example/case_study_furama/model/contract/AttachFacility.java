package com.example.case_study_furama.model.contract;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "nvarchar(45)")
    private String name;

    private Double cost;

    @Column(columnDefinition = "nvarchar(45)")
    private String unit;

    @Column(columnDefinition = "nvarchar(45)")
    private String status;

}
