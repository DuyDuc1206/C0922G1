package ss3_arrays_and_methods_in_java.Practices;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseTheElementsOfArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        do {
            System.out.print("Enter the amount element of array: ");
            n = Integer.parseInt(scanner.nextLine());
        } while (n <= 0);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the element at position " + (i + 1) + " is ");
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
//        for (int item : arr) {
//            System.out.print(item + " ");
//        }
//        for (int i = 0; i <arr.length ; i++) {
//            System.out.print(arr[i] + " ");
//        }
        System.out.println("Array is: " + Arrays.toString(arr));
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        System.out.println("Array after reverse is: " + Arrays.toString(arr));
    }
}
