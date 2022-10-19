package case_study.model;

import case_study.model.facility.Facility;
import case_study.model.person.Person;

public class Booking extends Person {
    private double idBooking;
    private String startDate;
    private String endDate;
    private String facility;

    public Booking() {

    }

    public Booking(double id, String name, String gender, String date, double identityCardNumber, double phoneNumber, String email, double idBooking, String startDate, String endDate, String facility) {
        super(id, name, gender, date, identityCardNumber, phoneNumber, email);
        this.idBooking = idBooking;
        this.startDate = startDate;
        this.endDate = endDate;
        this.facility = facility;
    }

    public double getIdBooking() {
        return this.idBooking;
    }

    public void setIdBooking(double idBooking) {
        this.idBooking = idBooking;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getFacility() {
        return this.facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public String toString() {
        return "Id Booking: " + this.idBooking
                + " start date: " + this.startDate
                + " end date: " + this.endDate
                + " facility: " + this.facility;
    }
}
