package ss3_arrays_and_methods_in_java.Execises;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveElementFromArray {
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter amount element of array: ");
            n = Integer.parseInt(scanner.nextLine());
        } while (n < 0);
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter the element " + (i + 1) + ": ");
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Array is: " + Arrays.toString(arr));
        System.out.print("Enter element want delete: ");
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < arr.length; i++) {
            if (number == arr[i]) {
                for (int j = i; j <arr.length-1 ; j++) {
                    arr[j]=arr[j+1];
                }
                arr[n-1]=0;
                i--;
            }

        }
        System.out.println("Array after delete is: " + Arrays.toString(arr));
    }
}
