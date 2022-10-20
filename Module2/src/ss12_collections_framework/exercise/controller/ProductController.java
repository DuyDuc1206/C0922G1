package ss12_collections_framework.exercise.controller;

import ss12_collections_framework.exercise.model.Product;
import ss12_collections_framework.exercise.service.IService;
import ss12_collections_framework.exercise.service.impl.Service;

import java.util.Scanner;

public class ProductController {
    public static Scanner scanner = new Scanner(System.in);
    public static IService service = new Service();

    public static void displayMenu() {
        Product product1 = new Product(1,"jupiter",50000000);
        Product product2 = new Product(2,"exciter",70000000);
        Product product3 = new Product(3,"sirius",30000000);
        Service.productList.add(product1);
        Service.productList.add(product2);
        Service.productList.add(product3);
        while (true) {
            System.out.println("----------------Menu---------------");
            System.out.println("1. Add product");
            System.out.println("2. Edit product information by id");
            System.out.println("3. Delete product by id");
            System.out.println("4. Display product list");
            System.out.println("5. Search product by name");
            System.out.println("6. Sort product by price");
            System.out.println("7. Exit");
            System.out.print("Enter the number you choice: ");
            String number = scanner.nextLine();
            switch (number) {
                case "1":
                    service.add();
                    break;
                case "2":
                    service.edit();
                    break;
                case "3":
                    service.delete();
                    break;
                case "4":
                    service.display();
                    break;
                case "5":
                    service.search();
                    break;
                case "6":
                    service.sort();
                    break;
                case "7":
                    System.exit(1);
                default:
                    System.out.println("Please re-enter the number");
            }
        }
    }
}

