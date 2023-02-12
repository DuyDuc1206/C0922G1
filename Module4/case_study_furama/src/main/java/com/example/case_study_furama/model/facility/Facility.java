package com.example.case_study_furama.model.facility;

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
public class Facility {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "nvarchar(45)")
    private String name;

    private Integer area;
    private Double cost;
    private Integer maxPeople;

    @Column(columnDefinition = "nvarchar(45)")
    private String standardRoom;

    @Column(columnDefinition = "nvarchar(45)")
    private String description;

    private Double poolArea;
    private Integer numberOfFloor;

    @Column(columnDefinition = "text")
    private String facilityFree;

    @ManyToOne
    private RentType rentType;

    @ManyToOne
    private FacilityType facilityType;

}
