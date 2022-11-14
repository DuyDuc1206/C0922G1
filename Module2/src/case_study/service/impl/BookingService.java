package case_study.service.impl;

import case_study.Utils.CheckUtils;
import case_study.Utils.CompareBooking;
import case_study.Utils.FormatException;
import case_study.Utils.ReadAndWrite;
import case_study.model.Booking;
import case_study.model.facility.Facility;
import case_study.model.person.Customer;
import case_study.service.IBookingService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BookingService implements IBookingService {
    private Scanner scanner = new Scanner(System.in);
    private CustomerService customerList = new CustomerService();
    private FacilityService facilityList = new FacilityService();
    private Map<Facility, Integer> facilityMap = facilityList.getFacilityIntegerMap();
    private TreeSet<Booking> bookingList = new TreeSet<>();
    private static final String BOOKING_FILE_PATH = "src\\case_study\\data\\Booking.csv";
    private static final String HEADER_BOOKING = "ID,START DATE,END DATE,ID CUSTOMER, SERVICE NAME";
    public static final String FILE_NAME_VILLA = "src\\case_study\\data\\Villa.csv";
    public static final String FILE_NAME_ROOM = "src\\case_study\\data\\Room.csv";
    public static final String FILE_HEADER_VILLA = "SERVICE,ID,AREA,PRICE,AMOUNT,RENTAL TIME,STANDARD,SWIMMING POOL AREA,NUMBER OF FLOOR,TIMES";
    public static final String FILE_HEADER_ROOM = "SERVICE,ID,AREA,PRICE,AMOUNT,RENTAL TIME,FREE SERVICE,TIMES";

    //    LocalDate localDate = LocalDate.now();
    public void add() {
        bookingList = ReadAndWrite.readBookingFile(BOOKING_FILE_PATH);
        System.out.println("List customer");
        customerList.display();
        System.out.println("List service");
        facilityList.display();
        Booking booking = getinfo();
        bookingList.add(booking);
        ReadAndWrite.writeBookingFile(BOOKING_FILE_PATH, bookingList);
//        System.out.println(facilityMap);
        for (Booking key : bookingList) {
            if (key.getServiceName().contains("RO")) {
                for (Map.Entry<Facility, Integer> entry : facilityMap.entrySet()) {
                    if (entry.getKey().getServiceCode().contains(booking.getServiceName())) {
                        facilityMap.replace(entry.getKey(), entry.getValue() + 1);
                        ReadAndWrite.writeFacilityFile(FILE_NAME_ROOM, facilityMap, FILE_HEADER_ROOM);
                    }
                }
            }
            if (key.getServiceName().contains("VL")) {
                for (Map.Entry<Facility, Integer> entry : facilityMap.entrySet()) {
                    if (entry.getKey().getServiceCode().contains(booking.getServiceName())) {
                        facilityMap.replace(entry.getKey(), entry.getValue() + 1);
                        ReadAndWrite.writeFacilityFile(FILE_NAME_VILLA, facilityMap, FILE_HEADER_VILLA);
                    }
                }
            }

        }


        System.out.println("You added successfully");
    }

    public void display() {
        bookingList = ReadAndWrite.readBookingFile(BOOKING_FILE_PATH);
        if (bookingList.isEmpty()) {
            System.out.println("List Booking is empty!!!");
        }
        for (Booking booking : bookingList) {
            System.out.println(booking.toString());
        }
    }

    private Booking getinfo() {
        String bookingId;
        LocalDate startDate;
        LocalDate endDate;
        String customerId;
        String serviceName;
        while (true) {
            System.out.println("Enter the booking id");
            bookingId = scanner.nextLine();
            try {
                CheckUtils.checkBookingId(bookingId);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            System.out.println("Enter the booking start day (dd-MM-yyyy)");
            try {
                String date = scanner.nextLine();
                CheckUtils.checkBookingDate(date);
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                startDate = LocalDate.parse(date, dateTimeFormatter);
                break;
            } catch (FormatException | NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            System.out.println("Enter the booking end day (dd-MM-yyyy)");
            try {
                String date = scanner.nextLine();
                CheckUtils.checkBookingDate(date);
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                endDate = LocalDate.parse(date, dateTimeFormatter);
                if (endDate.isAfter(startDate)) {
                    break;
                } else {
                    System.out.println("Input again. End day has to be after start day");
                }
            } catch (NumberFormatException | FormatException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            System.out.println("Enter the customer id ");
            customerId = scanner.nextLine();
            try {
                CheckUtils.checkId(customerId);
                boolean flagCheck = false;
                for (Customer customer : customerList.getCustomerList()) {
                    if (customer.getId().equals(customerId)) {
                        flagCheck = true;
                        break;
                    }
                }
                if (!flagCheck) {
                    System.out.println("Wrong customer id . Enter again!");
                } else {
                    break;
                }
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            System.out.println("Enter the service name");
            serviceName = scanner.nextLine();
            try {
                CheckUtils.checkIdService(serviceName);
                boolean flagCheck = false;
                Set<Facility> keys = facilityMap.keySet();
                for (Facility facility : keys) {
                    if (facility.getServiceCode().equals(serviceName)) {
                        flagCheck = true;
                        break;
                    }
                }
                if (!flagCheck) {
                    System.out.println("Wrong service name.Enter again!");
                } else {
                    break;
                }
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }
        }
        return new Booking(bookingId, startDate, endDate, customerId, serviceName);
    }
    public void compareToDate(){
        bookingList = ReadAndWrite.readBookingFile(BOOKING_FILE_PATH);
//        Collections.sort(bookingList,new CompareBooking());
    }
}

