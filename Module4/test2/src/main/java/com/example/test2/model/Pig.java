package com.example.test2.model;

import javax.persistence.*;

@Entity
public class Pig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String codePig;
    private String dateAdded;
    private double weightEntering;
    private String exportDate;
    private double weightExport;

    @ManyToOne
    private Origin origin;

    private String status;


    public Pig() {
    }

    public Pig(Integer id, String codePig, String dateAdded, double weightEntering, String exportDate, double weightExport, Origin origin, String status) {
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
}
