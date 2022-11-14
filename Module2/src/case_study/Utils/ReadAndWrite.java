package case_study.Utils;

import case_study.model.Booking;
import case_study.model.facility.Facility;
import case_study.model.facility.Room;
import case_study.model.facility.Villa;
import case_study.model.person.Customer;
import case_study.model.person.Employee;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ReadAndWrite {
//    public static void writeFileFacility(String pathFile, Map<Facility, Integer> facilityIntegerMap) {
//        try {
//            FileWriter fileWriter = new FileWriter(new File(pathFile));
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            String line;
//            Set<Facility> facilitySet = facilityIntegerMap.keySet();
//            for (Facility facility : facilitySet) {
//                if (facility.getServiceCode().contains("VL")) {
//                    line = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", facility.getServiceName(), facility.getServiceCode(), facility.getUsableArea(), facility.getRentalCosts(), facility.getMaxNumberOfPeople(), facility.getRentalTime(), ((Villa) facility).getRoomStandard(), ((Villa) facility).getSwimmingPoolArea(), ((Villa) facility).getNumberOfFloors(), facilityIntegerMap.get(facility));
//                    bufferedWriter.write(line);
//                    bufferedWriter.newLine();
//                }
//                if (facility.getServiceCode().contains("RO")) {
//                    line = String.format("%s,%s,%s,%s,%s,%s,%s,%s", facility.getServiceName(), facility.getServiceCode(), facility.getUsableArea(), facility.getRentalCosts(), facility.getMaxNumberOfPeople(), facility.getRentalTime(), ((Room) facility).getFreeServiceIncluded(), facilityIntegerMap.get(facility));
//                    bufferedWriter.write(line);
//                    bufferedWriter.newLine();
//                }
//            }
//            bufferedWriter.close();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public static Map<Facility, Integer> readFileFacility(String pathFile, Map<Facility, Integer> facilityIntegerMap) {
//        try {
//            FileReader fileReader = new FileReader(new File(pathFile));
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String line;
//            String[] info;
//            facilityIntegerMap.clear();
//            while ((line = bufferedReader.readLine()) != null) {
//                info = line.split(",");
//                if (info[1].contains("VL")) {
//                    facilityIntegerMap.put(new Villa(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]), Double.parseDouble(info[4]), info[5], info[6], Double.parseDouble(info[7]), Double.parseDouble(info[8])), Integer.parseInt(info[9]));
//                }
//                if (info[1].contains("RO")) {
//                    facilityIntegerMap.put(new Room(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]), Double.parseDouble(info[4]), info[5], info[6]), Integer.parseInt(info[7]));
//                }
//            }
//            bufferedReader.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("Not Found Find!!!");
//        } catch (IOException e) {
//            System.out.println("Error !! When read file");
//        }
//        return facilityIntegerMap;
//    }

    //    public static List<Employee> readEmployeeFile(String pathFile,List<Employee> employeeList) {
//        try {
//            FileReader fileReader = new FileReader(new File(pathFile));
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String line;
//            String[] info;
//
//            while ((line = bufferedReader.readLine()) != null) {
//                info = line.split(",");
//                employeeList.add(new Employee(info[0], info[1], info[2], info[3], info[4],info[5], info[6], info[7], info[8], Double.parseDouble(info[9])));
//            }
//            bufferedReader.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return employeeList;
//    }
//    public static void writeEmployeeFile(String pathFile,List<Employee> employeeList){
//        try {
//            FileWriter fileWriter =  new FileWriter(new File(pathFile),true);
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            String line;
//            for (Employee employee:employeeList){
//                line =String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",employee.getId(),employee.getName(),employee.getGender(),employee.getDate(),employee.getIdentityCardNumber(),employee.getPhoneNumber(),employee.getEmail(),employee.getLocation(),employee.getLevel(),employee.getSalary());
//                bufferedWriter.write(line);
//                bufferedWriter.newLine();
//            }
//            bufferedWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public static List<Customer> readCustomerFile (String pathFile,List<Customer> customerList){
//        try {
//            FileReader fileReader = new FileReader(new File(pathFile));
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String line;
//            String[] info;
//            customerList.clear();
//            while ((line=bufferedReader.readLine())!=null){
//                if ("".equals(line)) continue;
//                info = line.split(",");
//                customerList.add(new Customer(info[0],info[1],info[2],info[3],info[4],info[5],info[6],info[7],info[8]));
//            }
//            bufferedReader.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return customerList;
//    }
//    public static void writeCustomerFile(String pathFile,List<Customer> customerList){
//
//        try {
//            FileWriter fileWriter = new FileWriter(new File(pathFile));
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            String line;
//            for (Customer customer:customerList){
//                line = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s",customer.getId(),customer.getName(),customer.getGender(),customer.getDate(),customer.getIdentityCardNumber(),customer.getPhoneNumber(),customer.getEmail(),customer.getCustomerType(),customer.getAddress());
//                bufferedWriter.write(line);
//                bufferedWriter.newLine();
//            }
//            bufferedWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    public static List<Customer> readCustomerFile(String pathFile) {
        List<Customer> customerList = new LinkedList<>();
        try {
            FileReader fileReader = new FileReader(new File(pathFile));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                customerList.add(new Customer(info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7], info[8]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    public static void writeCustomerFile(String pathFile, List<Customer> customerList) {
        try {
            FileWriter fileWriter = new FileWriter(new File(pathFile));
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line;
            for (Customer customer : customerList) {
                line = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s", customer.getId(), customer.getName(), customer.getGender(), customer.getDate(), customer.getIdentityCardNumber(), customer.getPhoneNumber(), customer.getEmail(), customer.getCustomerType(), customer.getAddress());
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Employee> readEmployeeFile(String pathFile) {
        List<Employee> employeeList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(new File(pathFile));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                employeeList.add(new Employee(info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7], info[8], Double.parseDouble(info[9])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public static void writeEmployeeFile(String pathFile, List<Employee> employeeList) {
        try {
            FileWriter fileWriter = new FileWriter(new File(pathFile));
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line;
            for (Employee employee : employeeList) {
                line = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", employee.getId(), employee.getName(), employee.getGender(), employee.getDate(), employee.getIdentityCardNumber(), employee.getPhoneNumber(), employee.getEmail(), employee.getLocation(), employee.getLevel(), employee.getSalary());
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Facility, Integer> readFacilityFile(String pathFile) {
        Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
        try {
            FileReader fileReader = new FileReader(new File(pathFile));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                if (info[1].contains("VL")) {
                    facilityIntegerMap.put(new Villa(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]), Double.parseDouble(info[4]), info[5], info[6], Double.parseDouble(info[7]), Double.parseDouble(info[8])), Integer.parseInt(info[9]));
                }
                if (info[1].contains("RO")) {
                    facilityIntegerMap.put(new Room(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]), Double.parseDouble(info[4]), info[5], info[6]), Integer.parseInt(info[7]));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return facilityIntegerMap;
    }

    public static void writeFacilityFile(String pathFile, Map<Facility, Integer> facilityIntegerMap, String header) {
        try {
            FileWriter fileWriter = new FileWriter(new File(pathFile));
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(header);
            String line;
            Set<Facility> facilitySet = facilityIntegerMap.keySet();
            for (Facility facility : facilitySet) {
                if (facility.getServiceCode().contains("VL")) {
                    line = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", facility.getServiceName(), facility.getServiceCode(), facility.getUsableArea(), facility.getRentalCosts(), facility.getMaxNumberOfPeople(), facility.getRentalTime(), ((Villa) facility).getRoomStandard(), ((Villa) facility).getSwimmingPoolArea(), ((Villa) facility).getNumberOfFloors(), facilityIntegerMap.get(facility));
                    bufferedWriter.newLine();
                    bufferedWriter.write(line);
                }
                if (facility.getServiceCode().contains("RO")) {
                    line = String.format("%s,%s,%s,%s,%s,%s,%s,%s", facility.getServiceName(), facility.getServiceCode(), facility.getUsableArea(), facility.getRentalCosts(), facility.getMaxNumberOfPeople(), facility.getRentalTime(), ((Room) facility).getFreeServiceIncluded(), facilityIntegerMap.get(facility));
                    bufferedWriter.newLine();
                    bufferedWriter.write(line);
                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TreeSet<Booking> readBookingFile (String pathFile) {
        TreeSet<Booking> bookingList = new TreeSet<>();
        try {
            FileReader fileReader = new FileReader(new File(pathFile));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                bookingList.add(new Booking(info[0], LocalDate.parse(info[1], dateTimeFormatter), LocalDate.parse(info[2], dateTimeFormatter), info[3], info[4]));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return bookingList;
    }

    public static void writeBookingFile(String pathFile, TreeSet<Booking> bookingList) {
        try {
            FileWriter fileWriter = new FileWriter(new File(pathFile));
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            bufferedWriter.write(header);
            String line;
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            for (Booking booking : bookingList) {
                line = String.format("%s,%s,%s,%s,%s", booking.getIdBooking(), booking.getStartDate().format(dateTimeFormatter), booking.getEndDate().format(dateTimeFormatter), booking.getIdCustomer(), booking.getServiceName());
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
