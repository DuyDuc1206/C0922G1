package model.facility;

public class Facility {
    private int id;
    private String name;
    private int area;
    private double cost;
    private int maxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private Double poolArea;
    private Integer numberOfFloor;
    private String facilityFree;
    private int rentTypeId;
    private int facilityTypeId;
    private RentType rentTypeName;
    private FacilityType facilityTypeName;

    public Facility() {
    }

    public Facility(String name, int area, double cost, int maxPeople, String standardRoom, String descriptionOtherConvenience, Double poolArea, Integer numberOfFloor, String facilityFree, int rentTypeId, int facilityTypeId) {
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
        this.facilityFree = facilityFree;
        this.rentTypeId = rentTypeId;
        this.facilityTypeId = facilityTypeId;
    }

    public Facility(int id, String name, int area, double cost, int maxPeople, String standardRoom, String descriptionOtherConvenience, Double poolArea, Integer numberOfFloor, String facilityFree, int rentTypeId, int facilityTypeId) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
        this.facilityFree = facilityFree;
        this.rentTypeId = rentTypeId;
        this.facilityTypeId = facilityTypeId;
    }

    public Facility(int id, String name, int area, double cost, int maxPeople, String standardRoom, String descriptionOtherConvenient, Double poolArea, Integer numberOfFloor, String facilityFree, int rentTypeId, int facilityTypeId, RentType rentTypeName, FacilityType facilityTypeName) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenient;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
        this.facilityFree = facilityFree;
        this.rentTypeId = rentTypeId;
        this.facilityTypeId = facilityTypeId;
        this.rentTypeName = rentTypeName;
        this.facilityTypeName = facilityTypeName;
    }

    public Facility(int id, String name, int area, double cost, int maxPeople, String standardRoom, String descriptionOtherConvenience, Double poolArea, Integer numberOfFloor, String facilityFree, RentType rentTypeName, FacilityType facilityTypeName) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
        this.facilityFree = facilityFree;
        this.rentTypeName = rentTypeName;
        this.facilityTypeName = facilityTypeName;
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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenient(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(Integer numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String serviceFree) {
        this.facilityFree = facilityFree;
    }

    public int getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(int rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public int getFacilityTypeId() {
        return facilityTypeId;
    }

    public void setFacilityTypeId(int serviceTypeId) {
        this.facilityTypeId = facilityTypeId;
    }

    public RentType getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(RentType rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public FacilityType getFacilityTypeName() {
        return facilityTypeName;
    }

    public void setFacilityTypeName(FacilityType serviceTypeName) {
        this.facilityTypeName = facilityTypeName;
    }
}
