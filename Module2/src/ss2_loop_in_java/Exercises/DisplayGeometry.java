package ss2_loop_in_java.Exercises;

import com.sun.javafx.logging.JFRInputEvent;

import java.util.Scanner;

public class DisplayGeometry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length of rectangle ");
        int length = scanner.nextInt();
        System.out.print("Enter width of rectangle ");
        int width = scanner.nextInt();
        for (int i = 0; i <width ; i++) {
            for (int j = 0; j <length ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------");
        for (int i = 0; i <width ; i++) {
            for (int j = 0; j <=i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------");
        for (int i = 0; i <width ; i++) {
            for (int j = width; j >i ; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------");
        for (int i = 0; i <width ; i++) {
            for (int j = width -1 ; j >i ; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <=2*i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------");
    }
}
