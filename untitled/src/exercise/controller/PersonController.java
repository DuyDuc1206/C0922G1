package exercise.controller;

import exercise.service.IPerson;
import exercise.service.impl.DoctorService;
import exercise.service.impl.PatentService;
import exercise.service.impl.PersonService;

import java.util.Scanner;

public class PersonController {
    private static final Scanner sc = new Scanner(System.in);
    private static IPerson personService = new PersonService();
    private static PatentService patentService = new PatentService();
    private static DoctorService doctorService = new DoctorService();

    public static void displaymenu() {
        System.out.println("-----------Menu---------");
        System.out.println("1.Hiển thị bệnh nhân ");
        System.out.println("2. Hiển thị bác sĩ");
        System.out.println("3. Thoát");
        System.out.println("Lua chon");
        while (true) {
            String number = sc.nextLine();
            switch (number) {
                case "1":
                    patentService.display();
                    break;
                case "2":
                    doctorService.display();
                    break;
                case "3":
                    System.exit(0);
                default:
                    System.out.println("Nhap lai");
            }
        }
    }
}
