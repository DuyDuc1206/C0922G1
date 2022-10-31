package case_study.service.impl;

import case_study.model.facility.Facility;
import case_study.model.facility.Room;
import case_study.model.facility.Villa;
import case_study.service.IFacilityService;

import java.io.*;
import java.util.*;

public class FacilityService implements IFacilityService {
    List<String> stringList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static Map<Facility, Integer> serviceList = new LinkedHashMap<>();
    private static Integer value = 0;
    public void readFile() {
        try {
            File file = new File("src\\case_study\\data\\Facility.csv");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            if ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile() {
        try {
            File file = new File("src\\case_study\\data\\Facility.csv");
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Map.Entry<Facility, Integer> entry : serviceList.entrySet()) {

                bufferedWriter.write(entry.getKey() + ", times " + entry.getValue());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Facility getVillaInfor() {
        System.out.println("Enter the area use");
        double area = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter the price");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter maxPeople");
        int maxPeople = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Date of hire");
        String date = scanner.nextLine();
        System.out.println("Enter the standard room");
        String roomStandard = scanner.nextLine();
        System.out.println("Enter the swimming pool area");
        Double swimmingPoolArea = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter the number of floor");
        int numberFloor = Integer.parseInt(scanner.nextLine());
        return new Villa("Villa", area, price, maxPeople, date, roomStandard, swimmingPoolArea, numberFloor);
    }

    public Facility getRoomInfor() {
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
        return new Room("Room", area, price, maxPeople, date, freeServiceIncluded);
    }

    public void add() {
        readFile();
        System.out.println("1. Add new Villa");
        System.out.println("2. Add new Room");
        System.out.println("3. Back to menu");
        System.out.println("Enter the service you want add");
        String number = scanner.nextLine();
        switch (number) {
            case "1":
                Facility villa = getVillaInfor();
                serviceList.put(villa, value);
                break;
            case "2":
                Facility room = getRoomInfor();
                serviceList.put(room, 0);
                break;
            case "3":
                return;
            default:
                System.out.println("Re-enter the number");
        }
        writeFile();
    }

    public void display() {
//        Map<Facility,Integer> facilityList = getVillaInfor();
        for (Map.Entry<Facility, Integer> entry : serviceList.entrySet()) {
            System.out.println(entry.getKey() + ", times " + entry.getValue());
        }
        writeFile();


//    public void displayMaintenance(){
////        for (int i = 0; i < serviceList.size(); i++) {
////
////        }
//    }

    }
}
