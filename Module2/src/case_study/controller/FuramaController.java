package case_study.controller;

import case_study.service.IEmployeeService;
import case_study.service.IService;
import case_study.service.impl.EmployeeService;

import java.util.Scanner;

public  class FuramaController {
    static Scanner scanner = new Scanner(System.in);
    static IEmployeeService employeeService = new EmployeeService();
//    EmployeeController employeeController = new EmployeeController();

    public static void displayMainMenu() {

        String number;
        do {
            System.out.println("=================Menu==============");
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management");
            System.out.println("4. Booking Management");
            System.out.println("5. Promotion Management");
            System.out.println("6. Exit");
            System.out.println("Enter the service number you need");

            number = scanner.nextLine();
            switch (number) {

                case "1":
                    employeeMenu();
                    break;
                case "2":
                    customerMenu();
                    break;
                case "3":
                    facilityMenu();
                    break;
                case "4":
                    bookingMenu();
                    break;
                case "5":
                    promotionMenu();
                    break;
                case "6":
                    System.exit(1);
                default:
                    System.out.println("Re-enter the requested number, please!!!");
                    break;
            }
        } while (true);
    }

    public static void employeeMenu() {
//        boolean isChoise = false;
        while (true) {
            System.out.println("1. Display list employees");
            System.out.println("2. Add new employee");
            System.out.println("3. Delete employee");
            System.out.println("4. Edit employee");
            System.out.println("5. Return main menu");
            String number1 = scanner.nextLine();
            switch (number1) {
                case "1":
                    employeeService.display();
                    break;
                case "2":
                    employeeService.add();
                    break;
                case  "3":
                    employeeService.remove();
                    break;
                case "4":
                    employeeService.set();
                    break;
                case "5":
//                    isChoise = true;
//                    break;
                    return;
                default:
                    System.out.println("Re-Enter");
            }
        }
    }

    public static void customerMenu() {
        System.out.println("1. Display list customer");
        System.out.println("2. Add new customer");
        System.out.println("3. Edit customer");
        System.out.println("4. Return main menu");
    }

    public static void facilityMenu() {
        System.out.println("1. Display list facility");
        System.out.println("2. Add new facility");
        System.out.println("3. Display list facility maintenance");
        System.out.println("4. Return main menu");
    }

    public static void bookingMenu() {
        System.out.println("1. Add new booking");
        System.out.println("2. Display list booking");
        System.out.println("3. Return main menu");
    }

    public static void promotionMenu() {
        System.out.println("1. Display list customers use service");
        System.out.println("2. Display list customers get voucher");
        System.out.println("3. Return main menu");
    }
}
