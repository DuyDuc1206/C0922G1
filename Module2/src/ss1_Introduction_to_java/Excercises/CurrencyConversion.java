package ss1_Introduction_to_java.Excercises;

import java.util.Scanner;

public class CurrencyConversion {
    public static void main(String[] args) {
        int rate = 23000;
        System.out.print("Enter the mount you want to convert(USD): ");
        Scanner scanner = new Scanner(System.in);
        int USD = scanner.nextInt();
        int VND = USD * rate;
        System.out.printf("Amount after conversion is %d (VND)",VND);
    }
}
