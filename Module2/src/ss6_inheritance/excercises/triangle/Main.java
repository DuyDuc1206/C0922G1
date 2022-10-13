package ss6_inheritance.excercises.triangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the triangle color: ");
        String color = scanner.nextLine();
        System.out.print("Enter the side 1 of triangle: ");
        int side1 = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter the side 2 of triangle: ");
        int side2 = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter the side 3 of triangle: ");
        int side3 = Integer.parseInt(scanner.nextLine());
        Triangle triangle =new Triangle(side1,side2,side3,color);
        System.out.println(triangle);
    }
}
