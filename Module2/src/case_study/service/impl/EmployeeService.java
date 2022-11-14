package case_study.service.impl;

import case_study.Utils.ReadAndWrite;
import case_study.model.person.Employee;
import case_study.service.IEmployeeService;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    private static final Scanner scanner = new Scanner(System.in);
    private List<Employee> employeeList = new ArrayList<>();
    private static final String EMPLOYEE_fILE = "src\\case_study\\data\\Employee.csv";

    @Override
    public void display() {
        employeeList = ReadAndWrite.readEmployeeFile(EMPLOYEE_fILE);
        if (employeeList.isEmpty()) {
            System.out.println("List is empty!!!");
        }
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
    }

    @Override
    public void add() {
        Employee employee = this.info();
        employeeList.add(employee);
        ReadAndWrite.writeEmployeeFile(EMPLOYEE_fILE, employeeList);
        System.out.println("You added successfully: ");
    }

    public Employee info() {
        System.out.println("Enter id ");
        String id = scanner.nextLine();
        System.out.println("Enter name ");
        String name = scanner.nextLine();
        System.out.println("Enter gender ");
        String gender = scanner.nextLine();
        System.out.println("Enter date ");
        String date = scanner.nextLine();
        System.out.println("Enter identityCardNumber ");
        String identityCardNumber = scanner.nextLine();
        System.out.println("Enter phone Number ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter email ");
        String email = scanner.nextLine();
        System.out.println("Enter location ");
        String location = scanner.nextLine();
        System.out.println("Enter level ");
        String level = scanner.nextLine();
        System.out.println("Enter salary ");
        double salary = Double.parseDouble(scanner.nextLine());
        return new Employee(id, name, gender, date, identityCardNumber, phoneNumber, email, location, level, salary);
    }

    public void remove() {
        System.out.println("Enter id: ");
        double id = Double.parseDouble(scanner.nextLine());
        employeeList.remove(id);
        System.out.println("You deleted successfully");
    }

    public void edit() {
        System.out.println("Enter id you want edit: ");
        String id = scanner.nextLine();
        boolean isCheck = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == id) {
                employeeList.remove(employeeList.get(i));
                Employee employee = info();
                employeeList.add(employee);
                System.out.println("You edited successfully:");
                isCheck = true;
                break;
            }
        }
        if (!isCheck) {
            System.out.println("Not found id");
        }
    }
}
