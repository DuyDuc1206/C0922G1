package com.example.exam2.model;

import javax.persistence.*;

@Entity
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer codeCoach;
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

    public Coach() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodeCoach() {
        return codeCoach;
    }

    public void setCodeCoach(Integer codeCoach) {
        this.codeCoach = codeCoach;
    }

    public TypeCoach getTypeCoach() {
        return typeCoach;
    }

    public void setTypeCoach(TypeCoach typeCoach) {
        this.typeCoach = typeCoach;
    }

    public CompanyName getCompanyName() {
        return companyName;
    }

    public void setCompanyName(CompanyName companyName) {
        this.companyName = companyName;
    }

    public Position getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(Position startLocation) {
        this.startLocation = startLocation;
    }

    public Position getDestination() {
        return destination;
    }

    public void setDestination(Position destination) {
        this.destination = destination;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

}
