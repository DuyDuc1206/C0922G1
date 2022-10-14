package case_study.controller;

import java.util.Scanner;

public class FuramaController {
//    private IFuramaService iFuramaService = new FuramaService();
    public void displayMainMenu(){
        System.out.println("=================Menu==============");
        System.out.println("1. Employee Management");
        System.out.println("2. Customer Management");
        System.out.println("3. Facility Management");
        System.out.println("4. Booking Management");
        System.out.println("5. Promotion Management");
        System.out.println("6. Exit");
        System.out.println("Enter the service number you need");
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine(); // nhập kiểu string để tránh bắt lỗi nhập không phải kí tự số
        switch (number){
            case "1":
                System.out.println("1. Display list employees");
                System.out.println("2. Add new employee");
                System.out.println("3. Delete employee");
                System.out.println("4. Edit employee");
                System.out.println("5. Return main menu");
                break;
            case "2":
                System.out.println("1. Display list customer");
                System.out.println("2. Add new customer");
                System.out.println("3. Edit customer");
                System.out.println("4. Return main menu");
                break;
            case "3":
                System.out.println("1. Display list facility");
                System.out.println("2. Add new facility");
                System.out.println("3. Display list facility maintenance");
                System.out.println("4. Return main menu");
                break;
            case "4":
                System.out.println("1. Add new booking");
                System.out.println("2. Display list booking");
                System.out.println("3. Return main menu");
                break;
            case "5":
                System.out.println("1. Display list customers use service");
                System.out.println("2. Display list customers get voucher");
                System.out.println("3. Return main menu");
                break;
            case "6":
            default:
                System.out.println("Re-enter the requested number, please!!!");

        }
    }

}
