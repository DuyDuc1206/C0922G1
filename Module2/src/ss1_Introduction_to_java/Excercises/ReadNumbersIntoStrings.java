
package ss1_Introduction_to_java.Excercises;

import java.util.Scanner;

public class ReadNumbersIntoStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            System.out.print("Enter non-negative integer with up to 3 digits ");
            number = Integer.parseInt(scanner.nextLine());
        } while (number >= 1000 || number <= 0);
        int ones = number % 10;
        int tens = (number / 10) % 10;
        int hundreds = number / 100;

//
//            if (!theThirdNumber.equals(" ") || !theSecondNumber.equals(" ") || !theFirstNumber.equals(" ")) {
//                System.out.printf("Number: %s %s %s ", theThirdNumber, theSecondNumber, theFirstNumber);
//            } else {
//                System.out.println("Out of ability");
//            }
    }
}
