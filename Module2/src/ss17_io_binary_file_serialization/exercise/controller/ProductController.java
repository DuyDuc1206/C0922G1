package ss17_io_binary_file_serialization.exercise.controller;

import ss17_io_binary_file_serialization.exercise.service.IService;
import ss17_io_binary_file_serialization.exercise.service.impl.Service;

import java.io.IOException;
import java.util.Scanner;

public class ProductController {
    private static Scanner scanner = new Scanner(System.in);
    private static IService service = new Service();
    public static void display() throws IOException, ClassNotFoundException {
        String number;
        do {
            System.out.println("========================Menu======================");
            System.out.println("1. Display the products");
            System.out.println("2. Add the products");
            System.out.println("3. Search the products");
            System.out.println("4. Delete the products");
            System.out.println("5. Edit the products");
            System.out.println("6. Exit");
            System.out.println("Choose number");
            number = scanner.nextLine();
            switch (number){
                case "1":
                    service.display();
                    break;
                case "2":
                    service.add();
                    break;
                case "3":
                    service.search();
                    break;
                case "4":
                    service.remove();
                    break;
                case "5":
                    service.edit();
                    break;
                case "6":
                    System.exit(0);
                default:
                    System.out.println("Re-enter number to choose");
            }
        }while (true);
    }
}
