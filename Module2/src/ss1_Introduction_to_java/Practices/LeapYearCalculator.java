package ss1_Introduction_to_java.Practices;

import java.time.Year;
import java.util.Scanner;

public class LeapYearCalculator {
    public static void main(String[] args) {
        System.out.print("Enter a year: ");
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.println(year + " is a leap year.");
                } else {
                    System.out.println(year + " isn't a leap year.");
                }
            } else {
                System.out.println(year + " is a leap year.");
            }
        } else {
            System.out.println(year + " isn't a leap year.");
        }
    }
}
