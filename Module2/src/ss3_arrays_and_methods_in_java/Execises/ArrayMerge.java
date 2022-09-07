package ss3_arrays_and_methods_in_java.Execises;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayMerge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1;
        do {
            System.out.print("Enter the amount element in the first array: ");
            n1 = Integer.parseInt(scanner.nextLine());
        } while (n1 < 0);
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            System.out.print("Enter elemnet at position " + (i + 1) + " is ");
            arr1[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("The first array is: " + Arrays.toString(arr1));
        int n2;
        do {
            System.out.print("Enter the mount element in the second array: ");
            n2 = Integer.parseInt(scanner.nextLine());
        } while (n2 < 0);
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            System.out.print("Enter element at position " + (i + 1) + " is ");
            arr2[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("The second array is: " + Arrays.toString(arr2));
        int[] arr3 = new int[n1 + n2];
        for (int i = 0; i < arr1.length; i++) {
            arr3[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            arr3[i + arr1.length] = arr2[i];
        }
        System.out.println("The Third array is: " + Arrays.toString(arr3));
    }
}