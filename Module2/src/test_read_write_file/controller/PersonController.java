package test_read_write_file.controller;

import test_read_write_file.service.IPersonal;
import test_read_write_file.service.impl.StudentService;
import test_read_write_file.service.impl.TeacherService;

import java.util.Scanner;

public class PersonController {
    private static final Scanner sc = new Scanner(System.in);
    private static final IPersonal studentService = new StudentService();
    private static final IPersonal teacherService = new TeacherService();
    static String number;
    public static void displayMenu(){
        while (true){
            System.out.println("menu");
            System.out.println("1. Student");
            System.out.println("2. Teacher");
            System.out.println("enter the chose");
            number = sc.nextLine();
            switch (number){
                case"1":
                    displayStudent();
                    break;
                case "2":
                    displayTeacher();
                    break;
                case "3":
                    System.exit(0);
                default:
                    System.out.println("re-Enter the chose");
            }
        }
    }
    public static void displayStudent(){

    }
    public static void displayTeacher(){

    }
}
