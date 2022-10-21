package ss13_search_algorithms.execise;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length of array: ");
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the element at position: " + (i + 1));
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Array: " + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("Array sort: " + Arrays.toString(arr));
        System.out.print("Enter the value you want search: ");
        int value = Integer.parseInt(scanner.nextLine());
        System.out.println(binarySearch(arr, 0, arr.length - 1, value));
    }

    public static int binarySearch(int[] arr, int left, int right, int value) {
        if (right >= left) {
            int mid = (right + left) / 2;
            if (arr[mid] == value) {
                return mid;
            }
            if (value > mid) {
                return binarySearch(arr, mid + 1, right, value);
            }
            return binarySearch(arr, left, mid - 1, value);
        }
        return -1;
    }
}
