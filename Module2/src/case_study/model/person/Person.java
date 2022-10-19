package case_study.model.person;

import java.time.LocalDate;

public abstract class Person {
    private double id;
    private String name;
    private String date; // String, Date or LocalDate
    private String gender;
    private double identityCardNumber;
    private double phoneNumber;
    private String email;
    public Person(){

    }
    public Person(double id, String name, String gender, String date, double identityCardNumber, double phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.date = date;
        this.identityCardNumber = identityCardNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getIdentityCardNumber() {
        return identityCardNumber;
    }

    public void setIdentityCardNumber(double identityCardNumber) {
        this.identityCardNumber = identityCardNumber;
    }

    public double getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(double phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", gender='" + gender + '\'' +
                ", identityCardNumber=" + identityCardNumber +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' ;
    }
}
