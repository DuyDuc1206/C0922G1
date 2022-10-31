package ss17_io_binary_file_serialization.exercise.service.impl;

import ss17_io_binary_file_serialization.exercise.model.Product;
import ss17_io_binary_file_serialization.exercise.model.SortProductById;
import ss17_io_binary_file_serialization.exercise.service.IService;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Service implements IService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Product> productList = new ArrayList<>();


    public void readFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream("src\\ss17_io_binary_file_serialization\\exercise\\data\\data.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            productList = (List<Product>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void readFileCharacter(){
        try {
            File file = new File("src\\ss17_io_binary_file_serialization\\exercise\\data\\data3.csv");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public void writeFileCharacter() {
        try {
            File file = new File("src\\ss17_io_binary_file_serialization\\exercise\\data\\data3.csv");
            FileWriter fileWriter = new FileWriter(file,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(Product product:productList){
                bufferedWriter.write(String.format("Id: %s,Name: %s,Brand: %s,Price: %s,Description: %s\n",product.getId(),product.getProductName(),product.getProductBrand(),product.getPrice(),product.getOtherDescription()));
//                bufferedWriter.flush();
//                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

        public void writeFile () {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream("src\\ss17_io_binary_file_serialization\\exercise\\data\\data.dat");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(productList);
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public void display () {
            readFileCharacter();
//            readFile();
            for (Product product : productList) {
                System.out.println(product);
            }
        }

        public void add () {
            readFileCharacter();
//            readFile();
            Product product = this.infor();
            productList.add(product);
            System.out.println("You added successfully!!!");
//            writeFile();
            writeFileCharacter();
        }

        public Product infor () {
            System.out.println("Enter the id product");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter the product name");
            String productName = scanner.nextLine();
            System.out.println("Enter the product brand");
            String productBrand = scanner.nextLine();
            System.out.println("Enter the product price");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter the other description");
            String description = scanner.nextLine();
            return new Product(id, productName, productBrand, price, description);
        }

        public void search () {
            readFileCharacter();
//            readFile();
            boolean isCheck = false;
            System.out.println("Enter the id product");
            int number = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < productList.size(); i++) {
                if (number == productList.get(i).getId()) {
                    System.out.println(productList.get(i).toString());
                    isCheck = true;
                }
            }
            if (!isCheck) {
                System.out.println("Not found id!!!");
            }
        }

        public void remove () {
            readFileCharacter();
//            readFile();
            boolean isCheck = false;
            System.out.println("Enter the id product");
            int number = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < productList.size(); i++) {
                if (number == productList.get(i).getId()) {
                    productList.remove(i);
                    System.out.println("You deleted successfully!!!");
                    isCheck = true;
                }
            }
            if (!isCheck) {
                System.out.println("Not found id!!!");
            }
//            writeFile();
            writeFileCharacter();
        }

        public void edit () {
            readFileCharacter();
//            readFile();
            boolean isCheck = false;
            System.out.println("Enter the id product");
            int number = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < productList.size(); i++) {
                if (number == productList.get(i).getId()) {
                    productList.remove(i);
                    Product product = this.infor();
                    productList.add(i, product);
                    System.out.println("You edit successfully!!!");
                    isCheck = true;
                }
            }
            if (!isCheck) {
                System.out.println("Not id found!!!");
            }
//            writeFile();
            writeFileCharacter();
        }
        public void sort(){
            readFileCharacter();
            for (Product product:productList){
                System.out.println(product);
            }
            Collections.sort(productList);
//            System.out.println(productList);
            writeFileCharacter();
        }
        public void sortById(){
//            readFileCharacter();
        Collections.sort(productList,new SortProductById());
            writeFileCharacter();
        }
    }
