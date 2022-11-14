package case_study.service.impl;

import case_study.Utils.CheckUtils;
import case_study.Utils.FormatException;
import case_study.Utils.ReadAndWrite;
import case_study.model.facility.Facility;
import case_study.model.facility.Room;
import case_study.model.facility.Villa;
import case_study.service.IFacilityService;

import java.util.*;

public class FacilityService implements IFacilityService {

    private Scanner scanner = new Scanner(System.in);
    private Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
    public static final String FILE_NAME_VILLA = "src\\case_study\\data\\Villa.csv";
    public static final String FILE_NAME_ROOM = "src\\case_study\\data\\Room.csv";
    public static final String FILE_HEADER_VILLA = "SERVICE,ID,AREA,PRICE,AMOUNT,RENTAL TIME,STANDARD,SWIMMING POOL AREA,NUMBER OF FLOOR,TIMES";
    public static final String FILE_HEADER_ROOM = "SERVICE,ID,AREA,PRICE,AMOUNT,RENTAL TIME,FREE SERVICE,TIMES";
    String serviceCode;
    double area;
    double price;
    int maxPeople;
    String date;

    public Map<Facility, Integer> getFacilityIntegerMap() {
        facilityIntegerMap = ReadAndWrite.readFacilityFile(FILE_NAME_ROOM);
        facilityIntegerMap.putAll(ReadAndWrite.readFacilityFile(FILE_NAME_VILLA));
        return facilityIntegerMap;
    }

    public Facility getVillaInfor() {
        int numberFloor;
        String roomStandard;
        Double swimmingPoolArea;
        while (true) {
            System.out.println("Enter the service code");
            serviceCode = scanner.nextLine();
            try {
                CheckUtils.checkIdService(serviceCode);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            System.out.println("Enter the area use");
            area = Double.parseDouble(scanner.nextLine());
            try {
                CheckUtils.checkArea(area);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            System.out.println("Enter the price");
            price = Double.parseDouble(scanner.nextLine());
            try {
                CheckUtils.checkPrice(price);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            System.out.println("Enter maxPeople");
            maxPeople = Integer.parseInt(scanner.nextLine());
            try {
                CheckUtils.checkPeople(maxPeople);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            System.out.println("Enter Date of hire");
            date = scanner.nextLine();
            try {
                CheckUtils.checkDateRent(date);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            System.out.println("Enter the standard room");
            roomStandard = scanner.nextLine();
            try {
                CheckUtils.checkName(roomStandard);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            System.out.println("Enter the swimming pool area");
            swimmingPoolArea = Double.parseDouble(scanner.nextLine());
            try {
                CheckUtils.checkArea(swimmingPoolArea);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            System.out.println("Enter the number of floor");
            numberFloor = Integer.parseInt(scanner.nextLine());
            try {
                CheckUtils.checkFloor(numberFloor);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }
        }
        return new Villa("Villa", serviceCode, area, price, maxPeople, date, roomStandard, swimmingPoolArea, numberFloor);
    }

    public Facility getRoomInfor() {
        while (true) {
            System.out.println("Enter the service code");
            serviceCode = scanner.nextLine();
            try {
                CheckUtils.checkIdService(serviceCode);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            System.out.println("Enter the area use");
            area = Double.parseDouble(scanner.nextLine());
            try {
                CheckUtils.checkArea(area);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            System.out.println("Enter the price");
            price = Double.parseDouble(scanner.nextLine());
            try {
                CheckUtils.checkPrice(price);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            System.out.println("Enter maxPeople");
            maxPeople = Integer.parseInt(scanner.nextLine());
            try {
                CheckUtils.checkPeople(maxPeople);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            System.out.println("Enter Date of hire");
            date = scanner.nextLine();
            try {
                CheckUtils.checkDateRent(date);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Enter free service included");
        String freeServiceIncluded = scanner.nextLine();
        return new Room("Room", serviceCode, area, price, maxPeople, date, freeServiceIncluded);
    }

    public void add() {
        System.out.println("1. Add new Villa");
        System.out.println("2. Add new Room");
        System.out.println("3. Back to menu");
        System.out.println("Enter the service you want add");
        String number = scanner.nextLine();
        switch (number) {
            case "1":
                facilityIntegerMap = ReadAndWrite.readFacilityFile(FILE_NAME_VILLA);
                Facility villa = getVillaInfor();
                facilityIntegerMap.put(villa, 0);
                ReadAndWrite.writeFacilityFile(FILE_NAME_VILLA, facilityIntegerMap, FILE_HEADER_VILLA);
                System.out.println("You added successfully!!");
                break;
            case "2":
                facilityIntegerMap = ReadAndWrite.readFacilityFile(FILE_NAME_ROOM);
                Facility room = getRoomInfor();
                facilityIntegerMap.put(room, 0);
                ReadAndWrite.writeFacilityFile(FILE_NAME_ROOM, facilityIntegerMap, FILE_HEADER_ROOM);
                System.out.println("You added successfully!!");
                break;
            case "3":
                return;
            default:
                System.out.println("Re-enter the number");
        }
    }

    public void display() {
        facilityIntegerMap = ReadAndWrite.readFacilityFile(FILE_NAME_VILLA);
        for (Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()) {
            System.out.println(entry.getKey());
        }
        facilityIntegerMap = ReadAndWrite.readFacilityFile(FILE_NAME_ROOM);
        for (Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()) {
            System.out.println(entry.getKey());
        }
        if (facilityIntegerMap.size() == 0) {
            System.out.println("Map No data!!!");
        }
    }

    public void displayMaintenance() {
        facilityIntegerMap = ReadAndWrite.readFacilityFile(FILE_NAME_VILLA);
        facilityIntegerMap = ReadAndWrite.readFacilityFile(FILE_NAME_ROOM);
        boolean flag = false;
        for (Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()) {
            if (entry.getValue() >= 5) {
                flag = true;
                System.out.println(entry.getKey() + ", times: " + entry.getValue());
            }
        }
        if (!flag) {
            System.out.println("No service needs maintenance!");
        }
    }
}
