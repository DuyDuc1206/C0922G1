package com.example.case_study_furama.model.contract;

import com.example.case_study_furama.model.customer.Customer;
import com.example.case_study_furama.model.employee.Employee;
import com.example.case_study_furama.model.facility.Facility;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "datetime")
    private String startDate;

    @Column(columnDefinition = "datetime")
    private String endDate;

    private Double deposit;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Facility facility;

    @OneToMany(mappedBy = "contract")
    @JsonBackReference
    private Set<ContractDetail> contractDetailSet;
}
