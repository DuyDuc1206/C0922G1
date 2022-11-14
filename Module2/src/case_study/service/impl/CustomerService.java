package case_study.service.impl;

import case_study.Utils.CheckUtils;
import case_study.Utils.FormatException;
import case_study.Utils.ReadAndWrite;
import case_study.model.person.Customer;
import case_study.service.ICustomerService;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerService implements ICustomerService {
    private static final Scanner scanner = new Scanner(System.in);
    private List<Customer> customerList = new LinkedList<>();
    private static final String CUSTOMER_FILE = "src\\case_study\\data\\Customer.csv";

    public List<Customer> getCustomerList(){
        customerList = ReadAndWrite.readCustomerFile(CUSTOMER_FILE);
        return customerList;
    }
    public Customer infor() {
        String id;
        String name;
        String gender;
        String date;
        String identityCardNumber;
        String phone;
        String email;
        while (true) {
            System.out.println("Enter id");
            id = scanner.nextLine();
            try {
                CheckUtils.checkId(id);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            System.out.println("Enter name");
            name = scanner.nextLine();
            try {
                CheckUtils.checkName(name);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            System.out.println("Enter gender");
            gender = scanner.nextLine();
            try {
                CheckUtils.checkGender(gender);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            System.out.println("Enter date");
            date = scanner.nextLine();
            try {
                CheckUtils.checkDate(date);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            System.out.println("Enter identityCardNumber");
            identityCardNumber = scanner.nextLine();
            try {
                CheckUtils.checkCardNumber(identityCardNumber);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            System.out.println("Enter phone number");
            phone = scanner.nextLine();
            try {
                CheckUtils.checkPhoneNumber(phone);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            System.out.println("Enter email");
            email = scanner.nextLine();
            try {
                CheckUtils.checkGmail(email);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Enter customer type");
        String customerType = scanner.nextLine();
        System.out.println("Enter address");
        String address = scanner.nextLine();
        return new Customer(id, name, gender, date, identityCardNumber, phone, email, customerType, address);
    }

    public void add() {
        customerList = ReadAndWrite.readCustomerFile(CUSTOMER_FILE);
        Customer customer = infor();
        customerList.add(customer);
        System.out.println("You added successfully!");
        ReadAndWrite.writeCustomerFile(CUSTOMER_FILE, customerList);
    }

    public void display() {
        customerList = ReadAndWrite.readCustomerFile(CUSTOMER_FILE);
        if (customerList.isEmpty()) {
            System.out.println("NO DATA");
        }
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }

    }

    public void edit() {
        List<Customer> customerList = ReadAndWrite.readCustomerFile(CUSTOMER_FILE);
        boolean isCheck = false;
        System.out.println("Enter id you want edit: ");
        String id = scanner.nextLine();
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId().equals(id)) {
                customerList.remove(i);
                Customer customer = infor();
                customerList.add(customer);
                System.out.println("You edited successfully!");
                isCheck = true;
                break;
            }
        }
        if (!isCheck) {
            System.out.println("Not found id");
        }
        ReadAndWrite.writeCustomerFile(CUSTOMER_FILE, customerList);
    }
}
