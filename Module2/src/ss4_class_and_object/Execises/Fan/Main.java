package ss4_class_and_object.Execises.Fan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Fan fan = new Fan();
        System.out.println("1. Turn on the fan:");
        System.out.println("2. Turn off the fan:");
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter color for fan ");
        String color = scanner.nextLine();
        if (n == 1) {
            System.out.print("Enter color for fan ");
            fan.on = true;
            fan.speed = fan.FAST;
            fan.color = color;
            System.out.println(fan.display() + ", fan is on }");
        }
        if (n == 2) {
            fan.on = true;
            fan.color = color;
            fan.radius = 10;
            System.out.println(fan.display() + ", fan is off }");
        }
    }
}

