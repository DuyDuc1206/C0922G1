package com.example.case_study_furama.model.customer;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor@Data
@Getter
@Setter
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "nvarchar(45)")
    private String name;

}
