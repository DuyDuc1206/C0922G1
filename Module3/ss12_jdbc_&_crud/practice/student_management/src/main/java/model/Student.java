package model;

public class Student {
    private int id;
    private String name;
    private String gmail;
    private String country;

    public Student() {
    }

    public Student(String name, String gmail, String country) {
        this.name = name;
        this.gmail = gmail;
        this.country = country;
    }

    public Student(int id, String name, String gmail, String country) {
        this.id = id;
        this.name = name;
        this.gmail = gmail;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
