package case_study.model.facility;

public abstract class Facility {
    private String serviceName;
    private double usableArea;
    private double rentalCosts;
    private double maxNumberOfPeople;
    private String rentalTime;
    public Facility(){

    }
    public Facility(String serviceName,double usableArea, double rentalCosts, double maxNumberOfPeople, String rentalTime){
        this.serviceName= serviceName;
        this.usableArea =usableArea;
        this.rentalCosts = rentalCosts;
        this.maxNumberOfPeople = maxNumberOfPeople;
        this.rentalTime = rentalTime;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(double usableArea) {
        this.usableArea = usableArea;
    }

    public double getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(double rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public double getMaxNumberOfPeople() {
        return maxNumberOfPeople;
    }

    public void setMaxNumberOfPeople(double maxNumberOfPeople) {
        this.maxNumberOfPeople = maxNumberOfPeople;
    }

    public String getRentalTime() {
        return rentalTime;
    }

    public void setRentalTime(String rentalTime) {
        this.rentalTime = rentalTime;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "serviceName='" + serviceName + '\'' +
                ", usableArea=" + usableArea +
                ", rentalCosts=" + rentalCosts +
                ", maxNumberOfPeople=" + maxNumberOfPeople +
                ", rentalTime='" + rentalTime + '\'' +
                '}';
    }
}
