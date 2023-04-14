package com.example.exam2.dto;

import com.example.exam2.model.CompanyName;
import com.example.exam2.model.Position;
import com.example.exam2.model.TypeCoach;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoachDto {
    private Integer id;
    @NotNull
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
