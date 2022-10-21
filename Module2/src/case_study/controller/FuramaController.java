package case_study.controller;

import case_study.service.ICustomerService;
import case_study.service.IEmployeeService;
import case_study.service.IService;
import case_study.service.impl.CustomerService;
import case_study.service.impl.EmployeeService;

import java.util.Scanner;

public  class FuramaController {
    static Scanner scanner = new Scanner(System.in);
    static IEmployeeService employeeService = new EmployeeService();
    static ICustomerService customerService = new CustomerService();

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
        while (true) {
            System.out.println("1. Display list employees");
            System.out.println("2. Add new employee");
            System.out.println("3. Delete employee");
            System.out.println("4. Edit employee");
            System.out.println("5. Return main menu");
            System.out.println("Enter the number");
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
                    employeeService.edit();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Re-Enter the number");
            }
        }
    }

    public static void customerMenu() {
        while (true) {
            System.out.println("1. Display list customer");
            System.out.println("2. Add new customer");
            System.out.println("3. Edit customer");
            System.out.println("4. Return main menu");
            System.out.println("Enter the number");
            String number2 = scanner.nextLine();
            switch (number2){
                case "1":
                    customerService.display();
                    break;
                case "2":
                    customerService.add();
                    break;
                case "3":
                    customerService.edit();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Re-enter the number");
            }
        }
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
