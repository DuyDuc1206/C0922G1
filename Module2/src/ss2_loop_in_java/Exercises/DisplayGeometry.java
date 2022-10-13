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
//        Hình 1
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------");
//        Hình 2
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (i == 0 || i == width - 1 || j == 0 || j == length - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println("---------------------------------------");
//        Hình 3
        for (int i = 0; i < width; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------");
//        Hình4
        for (int i = 0; i < width; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i || i == width - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println("---------------------------------------");
//        HÌnh 5
        for (int i = 0; i < width; i++) {
            for (int j = width; j > i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------");
//        Hình 6
        for (int i = 0; i < width; i++) {
            for (int j = width - 1; j >= i; j--) {
                if (i == 0 || j == i || j == width - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
        System.out.println("---------------------------------------");
//        Hình 7
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = width; j > i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------");
//        Hình 8
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = width - 1; j >= i; j--) {
                if (i == 0 || j == i || j == width - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println("---------------------------------------");
//        Hình 9
        for (int i = 0; i < width; i++) {
            for (int j = width - 1; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                if (i == width - 1 || j == i || j == 0) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println("---------------------------------------");
//        Hình 10
        for (int i = 0; i < width; i++) {
            for (int j = width - 1; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------");
//        Hình 11
        for (int i = 0; i < width; i++) {
            for (int j = width - 1; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= 2 * i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------");
//        Hình 12
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 2 * width - 1; j > 2 * i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------");
//        Hình 13
        for (int i = 1; i <= width; i++) {
            for (int j = 1; j < 2 * width; j++) {
                if (Math.abs(width - j) == (i - 1) || (i == width)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println("---------------------------------------");
//        Hình 14
        for (int i = width; i > 0; i--) {
            for (int j = 1; j < 2 * width; j++) {
                if (Math.abs(width - j) == (i - 1) || (i == width)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println("---------------------------------------");
//        Hình 15
        for (int i = 1; i <= width; i++) {
            for (int j = 1; j < 2 * width; j++) {
                if (Math.abs(width - j) == (i - 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (int i = width - 1; i > 0; i--) {
            for (int j = 1; j < 2 * width; j++) {
                if (Math.abs(width - j) == (i - 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println("---------------------------------------");
//        Hinh 16
        for (int i = 2; i <= width + 1; i++) {
            for (int j = 1; j < 2 * width + 1; j++) {
                if (Math.abs(width + 1 - j) == (i - 1)) {
                    System.out.print(i - 1);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (int i = width + 1 -1; i > 1; i--) {
            for (int j = 1; j < 2 * width + 1; j++) {
                if (Math.abs(width + 1  - j) == (i -1) ) {
                    System.out.print(i - 1);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
