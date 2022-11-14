package test_read_write_file.service.impl;

import test_read_write_file.model.Student;
import test_read_write_file.service.IStudent;
import test_read_write_file.util.CompareScore;
import test_read_write_file.util.FormatException;
import test_read_write_file.util.ReadAndWrite;
import test_read_write_file.util.ValidateUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudent {
    private static final Scanner sc = new Scanner(System.in);
    private List<Student> studentList = new ArrayList<>();
    private static final String STUDENT_FILE = "src\\test_read_write_file\\data\\student.csv";

    @Override
    public void edit() {
        studentList = ReadAndWrite.readFile(STUDENT_FILE);
        String name = sc.nextLine();
        boolean flag = false;
        for (int i = 0; i <studentList.size() ; i++) {
            if(studentList.get(i).getName().equals(name)){
                Student student = this.info();
                studentList.remove(i);
                flag = true;
                System.out.println("You edit thanh cong");
                break;
            }
        }
        if(!flag){
            System.out.println("Not found it!");
        }
    }

    @Override
    public void add() {
        studentList = ReadAndWrite.readFile(STUDENT_FILE);
        Student student =this.info();
        studentList.add(student);
        ReadAndWrite.writeFile(STUDENT_FILE,studentList);
        System.out.println("You added successfully");

    }
    public Student info(){
        String name;
        LocalDate startDate;
        while (true){
            System.out.println("Enter the name");
            name= sc.nextLine();
            try {
                ValidateUtil.validateName(name);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true){
            System.out.println("Enter the date:(dd-MM-yyyy");
            try {
                String date = sc.nextLine();
                ValidateUtil.validateDate(date);
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                startDate = LocalDate.parse(date,dateTimeFormatter);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return new Student();
    }

    @Override
    public void display() {
        studentList = ReadAndWrite.readFile(STUDENT_FILE);
        for (Student student:studentList){
            System.out.println(student.toString());
        }
    }
    public void compare(){
        studentList = ReadAndWrite.readFile(STUDENT_FILE);
        Collections.sort(studentList,Collections.reverseOrder());
        ReadAndWrite.writeFile(STUDENT_FILE,studentList);
    }
    public void compareName(){
        studentList = ReadAndWrite.readFile(STUDENT_FILE);
        Collections.sort(studentList,new CompareScore());
        ReadAndWrite.writeFile(STUDENT_FILE,studentList);
    }
}
