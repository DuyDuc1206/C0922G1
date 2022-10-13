package ss4_class_and_object.Execises.Fan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fan fan = new Fan();
        int n;
        do {
            System.out.println("1. Turn on the fan:");
            System.out.println("2. Turn off the fan:");
            System.out.print("Choice ");
            n = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter color for fan ");
            String color = scanner.nextLine();
            fan.setColor(color);
            System.out.print("Enter radius for fan ");
            fan.setRadius(Integer.parseInt(scanner.nextLine()));
            switch (n) {
                case 1:
                    fan.on = true;
                    fan.speed = fan.FAST;
                    System.out.println(fan.display() + ", fan is on }");
                    break;
                case 2:
                    fan.on = true;
                    System.out.println(fan.display() + ", fan is off }");
            }
        } while (n < 1 || n > 2);
    }
}

