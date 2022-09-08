package ss3_arrays_and_methods_in_java.Execises;

import java.util.Arrays;
import java.util.Scanner;

public class FindMinInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            System.out.print("Enter the amount of element ");
            number = Integer.parseInt(scanner.nextLine());
        } while (number <= 0);
        int[] array = new int[number];
        for (int i = 0; i < number; i++) {
            System.out.print("Enter the element at position " + (i + 1) + " is: ");
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println(Arrays.toString(array));
        int min = array[0];
        for (int i = 0; i <array.length ; i++) {
            if ( min>array[i]) {
                min = array[i];
            }
        }
        System.out.println("Min number is: " + min);
    }
}
