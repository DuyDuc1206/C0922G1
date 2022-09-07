package ss3_arrays_and_methods_in_java.Execises;

import java.util.Arrays;
import java.util.Scanner;

public class AddElementToArray {
    public static void main(String[] args) {
        int number;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter amount element of array: ");
            number = Integer.parseInt(scanner.nextLine());
        } while (number < 0);
        int[] arr = new int[number];
        for (int i = 0; i < number; i++) {
            System.out.print("Enter element in " + (i + 1) + " position is: ");
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Array is: " + Arrays.toString(arr));
        int index;
        do {
            System.out.print("Enter a index want add: ");
            index = Integer.parseInt(scanner.nextLine());
            if (index < 0 || index >= arr.length - 1) {
                System.out.println("Unable to insert element into array, re-enter the index you want to insert!!!");
            }
        } while (index < 0 || index >= arr.length - 1);
        System.out.print("Enter element want add: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = arr.length-1; i >= 0; i--) {
           arr[i]=arr[i-1];
           if ( index == i) {
               arr[i]=n;
               break;
           }
        }
        System.out.println(Arrays.toString(arr));
    }
}
