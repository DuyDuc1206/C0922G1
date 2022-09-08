package ss3_arrays_and_methods_in_java.Execises;

import java.util.Scanner;

public class SumOfMainDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        do {
            System.out.print("Enter the edge of the square matrix ");
            n = Integer.parseInt(scanner.nextLine());
        } while (n <= 1);
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("Arr[%d][%d]: ", i, j);
                arr[i][j] = Integer.parseInt(scanner.nextLine());
            }
        }
        System.out.println("Array 2d is: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i][i];
            sum += arr[i][n - 1 - i];
        }
        System.out.print("Sum the number on the main diagonal of a square matrix is: " + sum);
    }
}
