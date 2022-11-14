package case_study.model.facility;

import case_study.model.facility.Facility;

public class Room extends Facility {
    private String freeServiceIncluded;

    public Room() {

    }

    public Room(String serviceName, String serviceCode, double usableArea, double rentalCosts, double maxNumberOfPeople, String rentalTime, String freeServiceIncluded) {
        super(serviceName, serviceCode, usableArea, rentalCosts, maxNumberOfPeople, rentalTime);
        this.freeServiceIncluded = freeServiceIncluded;
    }

    public String getFreeServiceIncluded() {
        return this.freeServiceIncluded;
    }

    public void setFreeServiceIncluded(String freeServiceIncluded) {
        this.freeServiceIncluded = freeServiceIncluded;
    }

    @Override
    public String toString() {
        return super.toString() +
                "freeServiceIncluded='" + freeServiceIncluded + '\'' +
                '}';
    }
}
