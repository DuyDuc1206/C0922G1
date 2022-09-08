
package ss1_Introduction_to_java.Excercises;

import java.util.Scanner;

public class aa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            System.out.print("Enter non-negative integer with up to 3 digits ");
            number = Integer.parseInt(scanner.nextLine());
        } while (number >= 1000 || number <= 0);
        int ones = number % 10;
        int tens = number % 100;
        int hundreds = number % 1000;
        if (number <= 10 && number > 0) {
            switch (number) {
                case 1:
                    System.out.println("One");
                    break;
                case 2:
                    System.out.println("Two");
                    break;
                case 3:
                    System.out.println("Three");
                    break;
                case 4:
                    System.out.println("Four");
                    break;
                case 5:
                    System.out.println("Five");
                    break;
                case 6:
                    System.out.println("Six");
                    break;
                case 7:
                    System.out.println("Seven");
                    break;
                case 8:
                    System.out.println("Eight");
                    break;
                case 9:
                    System.out.println("Nine");
                    break;
                case 10:
                    System.out.println("Ten");
                    break;
            }
        } else if (number < 20) {
            switch (ones) {
                case 1:
                    System.out.println("Elevent");
                    break;
                case 2:
                    System.out.println("Twelve");
                    break;
                case 3:
                    System.out.println("thirteen");
                    break;
                case 4:
                    System.out.println("Fourteen");
                    break;
                case 5:
                    System.out.println("Fiveteen");
                    break;
                case 6:
                    System.out.println("Sixteen");
                    break;
                case 7:
                    System.out.println("Seventeen");
                    break;
                case 8:
                    System.out.println("Eighteen");
                    break;
                case 9:
                    System.out.println("Nineteen");
                    break;
            }
        } else if (number < 120 && number > 110) {
            switch (number) {
                case 111:
                    System.out.println("One hundred and elevent");
                    break;
                case 112:
                    System.out.println("One hundred and Twelve");
                    break;
                case 113:
                    System.out.println("One hundred and thirteen");
                    break;
                case 114:
                    System.out.println("Onhundred and Fourteen");
                    break;
                case 115:
                    System.out.println("Onhundred and Fiveteen");
                    break;
                case 116:
                    System.out.println("One hundred and Sixteen");
                    break;
                case 117:
                    System.out.println("One hundred and Seventeen");
                    break;
                case 118:
                    System.out.println("One hundred and Eighteen");
                    break;
                case 119:
                    System.out.println("One hundred and Nineteen");
                    break;
            }
        } else if (number < 1000) {
            String theSecondNumber;
            switch (tens - ones) {
                case 0:
                    theSecondNumber = "and";
                    break;
                case 20:
                    theSecondNumber = "Twenty";
                    break;
                case 30:
                    theSecondNumber = "Thirty";
                    break;
                case 40:
                    theSecondNumber = "Fourty";
                    break;
                case 50:
                    theSecondNumber = "Fifty";
                    break;
                case 60:
                    theSecondNumber = "Sixty";
                    break;
                case 70:
                    theSecondNumber = "Seventy";
                    break;
                case 80:
                    theSecondNumber = "Eighty";
                    break;
                case 90:
                    theSecondNumber = "Ninety";
                    break;
                default:
                    theSecondNumber = "";
            }
            String theThirdNumber;
            switch (hundreds - tens) {
                case 100:
                    theThirdNumber = "One hundred";
                    break;
                case 200:
                    theThirdNumber = "Two hundred";
                    break;
                case 300:
                    theThirdNumber = "Three hundred";
                    break;
                case 400:
                    theThirdNumber = "Four hundred";
                    break;
                case 500:
                    theThirdNumber = "Five hundred";
                    break;
                case 600:
                    theThirdNumber = "Six hundred";
                    break;
                case 700:
                    theThirdNumber = "Seven hundred";
                    break;
                case 800:
                    theThirdNumber = "Eight hundred";
                    break;
                case 900:
                    theThirdNumber = "Nine hundred";
                    break;
                default:
                    theThirdNumber = "";
            }
            String theFirstNumber;
            switch (ones) {
                case 1:
                    theFirstNumber = "One";
                    break;
                case 2:
                    theFirstNumber = "Two";
                    break;
                case 3:
                    theFirstNumber = "Three";
                    break;
                case 4:
                    theFirstNumber = "Four";
                    break;
                case 5:
                    theFirstNumber = "Five";
                    break;
                case 6:
                    theFirstNumber = "Six";
                    break;
                case 7:
                    theFirstNumber = "Seven";
                    break;
                case 8:
                    theFirstNumber = "Eight";
                    break;
                case 9:
                    theFirstNumber = "Nine";
                    break;
                default:
                    theFirstNumber = "";
                    break;
            }
            if (!theThirdNumber.equals(" ") || !theSecondNumber.equals(" ") || !theFirstNumber.equals(" ")) {
                System.out.printf("Number: %s %s %s ", theThirdNumber, theSecondNumber, theFirstNumber);
            } else {
                System.out.println("Out of ability");
            }
        }
    }
}