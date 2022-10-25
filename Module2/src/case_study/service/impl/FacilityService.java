package case_study.service.impl;

import case_study.model.facility.Facility;
import case_study.model.facility.Room;
import case_study.service.IFacilityService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityService implements IFacilityService {
    private static Scanner scanner = new Scanner(System.in);
    private static LinkedHashMap<Facility, Integer> serviceList = new LinkedHashMap<>();

    public Facility getRoomInfor() {
        System.out.println("Enter the service name");
        String serviceName = scanner.nextLine();
        System.out.println("Enter the area use");
        double area = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter the price");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter maxPeople");
        int maxPeople = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Date of hire");
        String date = scanner.nextLine();
        System.out.println("Enter free service included");
        String freeServiceIncluded = scanner.nextLine();
        return new Room(serviceName, area, price, maxPeople, date, freeServiceIncluded);
    }

    public void add() {
        System.out.println("1. Add new Villa");
        System.out.println("2. Add new Room");
        System.out.println("3. Back to menu");
        System.out.println("Enter the service you want add");
        String number = scanner.nextLine();
        switch (number) {
            case "1":
                display();
                break;
            case "2":
                Facility facilityRoom = getRoomInfor();
                serviceList.put(facilityRoom, 1);
                break;
            default:
                System.out.println("Re-enter the number");
        }

    }

    public void display() {
        for(Map.Entry<Facility,Integer> entry:serviceList.entrySet()){
            System.out.println(entry.getKey());
        }
    }

    public void displayMaintenance() {
        for (int i = 0; i < serviceList.size(); i++) {

        }
    }

}
