package com.example.case_study_furama.dto;

import com.example.case_study_furama.model.facility.FacilityType;
import com.example.case_study_furama.model.facility.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;

public class FacilityDto implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "not empty")
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$", message = "First letter must be capitalized, name must not contain numbers")
    private String name;

    @NotNull(message = "not null")
    @Min(value = 50,message = "{error_area}")
    @Max(value = 500,message = "{error_area}")
    private Integer area;

    @NotNull(message = "not null")
    @DecimalMin(value = "1000000.0",message = "{error_cost}")
    @DecimalMax(value = "100000000.0",message = "{error_cost}")
    private double cost;

    @NotNull(message = "not null")
    private Integer maxPeople;

    @NotEmpty(message = "not empty")
    private String standardRoom;

    @NotEmpty(message = "not empty")
    private String description;

    private Double poolArea;
    private Integer numberOfFloor;
    private String facilityFree;
    private RentType rentType;
    private FacilityType facilityType;
    private boolean isDelete;

    public FacilityDto() {
    }

    public FacilityDto(Integer id, String name, Integer area, Double cost, Integer maxPeople, String standardRoom, String description, Double poolArea, Integer numberOfFloor, String facilityFree, RentType rentType, FacilityType facilityType, boolean isDelete) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
        this.facilityFree = facilityFree;
        this.rentType = rentType;
        this.facilityType = facilityType;
        this.isDelete = isDelete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(Integer numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
