package ss3_arrays_and_methods_in_java.Execises;

import java.util.Scanner;

public class SumNumberInAColumn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row;
        do {
            System.out.print("Enter the row of 2d array: ");
            row = Integer.parseInt(scanner.nextLine());
        } while (row <= 0);
        int colummn;
        do {
            System.out.print("Enter the column of 2d array: ");
            colummn = Integer.parseInt(scanner.nextLine());
        } while (colummn <= 0);
        int[][] arr = new int[row][colummn];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colummn; j++) {
                System.out.printf("Array[%d][%d] ", i, j);
                arr[i][j] = Integer.parseInt(scanner.nextLine());
            }
        }
        System.out.println("Array 2d is: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colummn; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        int n;
        do {
            System.out.print("Enter column want sum: ");
            n = Integer.parseInt(scanner.nextLine());
        } while (n < 0 || n > colummn);
        int sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colummn; j++) {
                if (j == (n-1)) {
                    sum += arr[i][j];
                }

            }
        }
        System.out.println("Sum of column at position " + n + " is: " + sum);
    }
}
