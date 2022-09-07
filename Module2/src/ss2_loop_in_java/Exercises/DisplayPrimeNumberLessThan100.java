package ss2_loop_in_java.Exercises;

import java.util.Scanner;

public class DisplayPrimeNumberLessThan100 {
    public static void main(String[] args) {
        System.out.print("Prime numbers less than: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int number = 2;
        while (number < n) {
            int count = 0;
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.print(number + ",");
            }
            number++;
        }
    }
}
