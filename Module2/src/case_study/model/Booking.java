package case_study.model;

import case_study.model.facility.Facility;
import case_study.model.person.Person;

import java.time.LocalDate;

public class Booking implements Comparable<Booking> {
    private String idBooking;
    private LocalDate startDate;
    private LocalDate endDate;
    private String idCustomer;
    private String serviceName;

    public Booking() {

    }

    public Booking(String idBooking, LocalDate startDate, LocalDate endDate, String idCustomer, String serviceName) {
        this.idBooking = idBooking;
        this.startDate = startDate;
        this.endDate = endDate;
        this.idCustomer = idCustomer;
        this.serviceName = serviceName;
    }

    public String getIdBooking() {
        return this.idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getIdCustomer() {
        return this.idCustomer;
    }

    public void setIdCustomer(String facility) {
        this.idCustomer = facility;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "idBooking='" + idBooking + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", idCustomer='" + idCustomer + '\'' +
                ", serviceName='" + serviceName + '\'' +
                '}';
    }

    public int compareTo(Booking o) {
        return this.getIdBooking().compareTo(o.getIdBooking());
    }
}
