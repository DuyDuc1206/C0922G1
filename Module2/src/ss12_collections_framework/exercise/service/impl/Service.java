package ss12_collections_framework.exercise.service.impl;

import ss12_collections_framework.exercise.model.Product;
import ss12_collections_framework.exercise.service.IService;

import java.util.ArrayList;
import java.util.Scanner;

public class Service implements IService {
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Product> productList = new ArrayList<>();

    public Product infor() {
        Integer productId;
        while (true) {
            boolean check = true;
            System.out.println("Enter the id: ");
            productId = Integer.parseInt(scanner.nextLine());
            for (Product product : productList) {
                if (product.getId().equals(productId)) {
                    System.out.println("This id already exists, please re-enter");
                    check = false;
                }
            }
            if (check) {
                break;
            }
        }
        System.out.println("Enter the name: ");
        String productName = scanner.nextLine();
        System.out.println("Enter the price: ");
        Integer productPrice = Integer.parseInt(scanner.nextLine());
        return new Product(productId, productName, productPrice);
    }

    public void add() {
        Product product = this.infor();
        productList.add(product);
        System.out.println("You have successfully added the product!!!");
    }

    public void edit() {
        boolean check = true;
        System.out.println("Enter the id you want edit:");
        Integer productId = Integer.parseInt(scanner.nextLine());
        for (Product product : productList) {
            if (product.getId().equals(productId)) {
                System.out.println("1. edit product name: ");
                System.out.println("2. edit product price: ");
                System.out.println("3. edit product name and price ");
                System.out.println("Enter number you wannt edit");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        System.out.println("Enter name:");
                        String productName = scanner.nextLine();
                        product.setName(productName);
                        System.out.println("Edit successfully!");
                        return;
                    case "2":
                        System.out.println("Enter price:");
                        Integer productPrice = Integer.parseInt(scanner.nextLine());
                        product.setPrice(productPrice);
                        System.out.println("Edit successfully!");
                        return;
                    case "3":
                        System.out.println("Enter name: ");
                        productName = scanner.nextLine();
                        product.setName(productName);
                        System.out.println("Enter price:");
                        productPrice = Integer.parseInt(scanner.nextLine());
                        product.setPrice(productPrice);
                        System.out.println("Edit successfully!");
                        return;

                }
                check = false;
                break;
            }
        }
        if (check) {
            System.out.println("This id doesn't exist");
        }
    }

    public void delete() {
        System.out.println("Enter the product id you want to delete: ");
        int productId = Integer.parseInt(scanner.nextLine());
        for (Product product : productList) {
            if (product.getId().equals(productId)) {
                productList.remove(product);
                System.out.println("Remove successfully!");
            }
        }
    }

    public void display() {
        for (Product product : productList) {
            System.out.println(product.toString());
        }
    }

    public void search() {
        System.out.println("Enter name");
        String productName = scanner.nextLine();
        int count = 0;
        for (Product product : productList) {
            if (product.getName().equals(productName)) {
                System.out.println(product.toString());
                count++;
            }
        }
        if (count != 1) {
            System.out.println("There is no product");
        }
    }

    public void sort() {
        productList.sort((o1, o2) -> o2.getPrice() - o1.getPrice());
        System.out.println(productList);
        productList.sort((o1, o2) -> o1.getPrice() - o2.getPrice());
        System.out.println(productList);
    }
}
