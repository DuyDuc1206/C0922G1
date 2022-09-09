package ss4_class_and_object.Execises.QuadraticEquation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Quadratic equation: ax2+bx+c=0 ( a#0)");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a: ");
        double a = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter b: ");
        double b = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter c: ");
        double c = Double.parseDouble(scanner.nextLine());
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        System.out.println("Delta = " + quadraticEquation.getDiscriminant());
        if (quadraticEquation.getDiscriminant() > 0) {
            System.out.printf("Solution of an equation is: x1 = %.2f and x2 = %.2f ",quadraticEquation.getRoot1(), quadraticEquation.getRoot2());
        } else if (quadraticEquation.getDiscriminant() == 0) {
            System.out.println(" Solution of an equation is: x1 = x2 = " + quadraticEquation.getRoot1());
        } else {
            System.out.println("Impossible equation");
        }
    }
}
