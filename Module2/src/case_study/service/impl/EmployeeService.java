package case_study.service.impl;

import case_study.model.person.Employee;
import case_study.service.IEmployeeService;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    private Scanner scanner = new Scanner(System.in);

    private static final List<Employee> employeeList = new ArrayList<>();

    @Override
    public void display() {
        for (int i = 0; i < employeeList.size(); i++) {
            System.out.println(employeeList.get(i));
        }
    }

    @Override
    public void add() {
        Employee employee = this.info();
        System.out.println(employee);
    }

    public Employee info() {
        System.out.println("Enter id ");
        double id = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter name ");
        String name = scanner.nextLine();
        System.out.println("Enter gender ");
        String gender = scanner.nextLine();
        System.out.println("Enter date ");
        String date = scanner.nextLine();
        System.out.println("Enter identityCardNumber ");
        double identityCardNumber = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter phone Number ");
        double phoneNumber = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter email ");
        String email = scanner.nextLine();
        System.out.println("Enter location ");
        String location = scanner.nextLine();
        System.out.println("Enter level ");
        String level = scanner.nextLine();
        System.out.println("Enter salary ");
        double salary = Double.parseDouble(scanner.nextLine());
        Employee employee = new Employee(id, name, gender, date, identityCardNumber, phoneNumber, email, location, level, salary);
        return employee;
    }
    public void remove(){
        System.out.println("Enter id: ");
        double id = Double.parseDouble(scanner.nextLine());
        employeeList.remove(id);
    }
    public void set(){
        System.out.println("Enter id: ");
        double id = Double.parseDouble(scanner.nextLine());
        for (int i = 0; i <employeeList.size() ; i++) {
            if ( employeeList.get(i).getId() == id ){
                System.out.println("Enter name ");
                String name = scanner.nextLine();
                System.out.println("Enter gender ");
                String gender = scanner.nextLine();
                System.out.println("Enter date ");
                String date = scanner.nextLine();
                System.out.println("Enter identityCardNumber ");
                double identityCardNumber = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter phone Number ");
                double phoneNumber = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter email ");
                String email = scanner.nextLine();
                System.out.println("Enter location ");
                String location = scanner.nextLine();
                System.out.println("Enter level ");
                String level = scanner.nextLine();
                System.out.println("Enter salary ");
                double salary = Double.parseDouble(scanner.nextLine());
                employeeList.get(i).setId(id);
                employeeList.get(i).setName(name);
                employeeList.get(i).setGender(gender);
                employeeList.get(i).setDate(date);
                employeeList.get(i).setIdentityCardNumber(identityCardNumber);
                employeeList.get(i).setPhoneNumber(phoneNumber);
                employeeList.get(i).setEmail(email);
                employeeList.get(i).setLocation(location);
                employeeList.get(i).setLevel(level);
                employeeList.get(i).setSalary(salary);
                System.out.println(employeeList);
            }
        }
    }
}
