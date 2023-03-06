package com.example.test2.dto;

import com.example.test2.model.Origin;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class PigDto implements Validator {

    private Integer id;
    @NotEmpty(message = "{Not empty}")
    @Pattern(regexp = "^MH[-]\\d+$",message = "ex: MH-02")
    private String codePig;
    private String dateAdded;
    @NotNull
    @Min(value = 50)
    private double weightEntering;
    private String exportDate;
    @NotNull
    @Min(value = 80)
    private double weightExport;
    @ManyToOne
    private Origin origin;

    private String status;

    public PigDto() {
    }

    public PigDto(Integer id, String codePig, String dateAdded, double weightEntering, String exportDate, double weightExport, Origin origin, String status) {
        this.id = id;
        this.codePig = codePig;
        this.dateAdded = dateAdded;
        this.weightEntering = weightEntering;
        this.exportDate = exportDate;
        this.weightExport = weightExport;
        this.origin = origin;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodePig() {
        return codePig;
    }

    public void setCodePig(String codePig) {
        this.codePig = codePig;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public double getWeightEntering() {
        return weightEntering;
    }

    public void setWeightEntering(double weightEntering) {
        this.weightEntering = weightEntering;
    }

    public String getExportDate() {
        return exportDate;
    }

    public void setExportDate(String exportDate) {
        this.exportDate = exportDate;
    }

    public double getWeightExport() {
        return weightExport;
    }

    public void setWeightExport(double weightExport) {
        this.weightExport = weightExport;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
