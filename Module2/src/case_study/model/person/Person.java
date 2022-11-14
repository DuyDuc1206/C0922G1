package case_study.model.person;

import java.time.LocalDate;

public abstract class Person {
    private String id;
    private String name;
    private String date; // String, Date or LocalDate
    private String gender;
    private String identityCardNumber;
    private String phoneNumber;
    private String email;
    protected Person(){

    }
    protected Person(String id, String name, String gender, String date, String identityCardNumber, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.date = date;
        this.identityCardNumber = identityCardNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getIdentityCardNumber() {
        return identityCardNumber;
    }

    public void setIdentityCardNumber(String identityCardNumber) {
        this.identityCardNumber = identityCardNumber;
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
