package ss3_arrays_and_methods_in_java.Execises;

import java.util.Arrays;
import java.util.Scanner;

public class FindMaxIn2dArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length of 2d array: ");
        int length = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter width of 2d array: ");
        int width = Integer.parseInt(scanner.nextLine());
        int[][] array = new int[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                System.out.printf("Array[%d][%d] ", (i), (j));
                array[i][j] = Integer.parseInt(scanner.nextLine());
            }
        }
        System.out.println("Array is:");
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        int max = array[0][0];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (max < array[i][j]) {
                    max = array[i][j];
                }
            }
        }
        System.out.println("Max number is: " + max);
    }
}
