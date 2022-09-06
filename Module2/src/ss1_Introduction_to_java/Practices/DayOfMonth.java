package ss1_Introduction_to_java.Practices;

import java.util.Scanner;

public class DayOfMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Which month that you want to count days? ");
        int month = scanner.nextInt();
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Month " + month + " has 31 day!");
                break;
            case 2:
                System.out.println("Month " + month + " has 28 or 29 day!");
                break;
            default:
                System.out.println("month " + month + " has 30 day!");
        }
    }
}
