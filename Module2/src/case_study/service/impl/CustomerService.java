package case_study.service.impl;

import case_study.model.person.Customer;
import case_study.service.ICustomerService;

import java.util.LinkedList;
import java.util.Scanner;

public class CustomerService implements ICustomerService {
    private static Scanner scanner = new Scanner(System.in);
    private static LinkedList<Customer> customerList = new LinkedList<>();
    public Customer infor(){
        System.out.println("Enter id");
        double id = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter gender");
        String gender = scanner.nextLine();
        System.out.println("Enter date");
        String date = scanner.nextLine();
        System.out.println("Enter identityCardNumber");
        double identityCardNumber = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter phone");
        double phone =Double.parseDouble(scanner.nextLine());
        System.out.println("Enter email");
        String email = scanner.nextLine();
        System.out.println("Enter customer type");
        String customerType = scanner.nextLine();
        System.out.println("Enter address");
        String address = scanner.nextLine();
        return new Customer(id,name,gender,date,identityCardNumber,phone,email,customerType,address);
    }
    public void add(){
        Customer customer = infor();
        customerList.add(customer);
        System.out.println("You added successfully!");
        }
    public void display(){
        for(Customer customer:customerList){
            System.out.println(customerList.toString());
        }
    }
    public void edit(){
        boolean isCheck = false;
        System.out.println("Enter id you want edit: ");
        double id = Double.parseDouble(scanner.nextLine());
        for (int i = 0; i <customerList.size() ; i++) {
            if ( customerList.get(i).getId()==id) {
                customerList.remove(i);
                Customer customer = infor();
                customerList.add(customer);
                System.out.println("You edited successfully!");
                isCheck = true;
                break;
            }
        }
        if (!isCheck){
            System.out.println("Not found id");
        }
    }
}
