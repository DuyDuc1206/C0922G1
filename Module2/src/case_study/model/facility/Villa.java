package case_study.model.facility;

import case_study.model.facility.Facility;

public class Villa extends Facility {
    private String roomStandard;
    private double swimmingPoolArea;
    private double numberOfFloors;
    public Villa(){

    }
    public Villa(String serviceName,double usableArea, double rentalCosts, double maxNumberOfPeople, String rentalTime,String roomStandard,double swimmingPoolArea, double numberOfFloors ){
        super(serviceName, usableArea, rentalCosts, maxNumberOfPeople, rentalTime);
        this.roomStandard=roomStandard;
        this.swimmingPoolArea=swimmingPoolArea;
        this.numberOfFloors=numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getSwimmingPoolArea() {
        return swimmingPoolArea;
    }

    public void setSwimmingPoolArea(double swimmingPoolArea) {
        this.swimmingPoolArea = swimmingPoolArea;
    }

    public double getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(double numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return super.toString() +
                "roomStandard='" + roomStandard + '\'' +
                ", swimmingPoolArea=" + swimmingPoolArea +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }
}
