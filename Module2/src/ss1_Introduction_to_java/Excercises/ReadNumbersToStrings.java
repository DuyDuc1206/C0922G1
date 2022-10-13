package ss1_Introduction_to_java.Excercises;

import java.util.Scanner;

public class ReadNumbersToStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number;
        do {
            System.out.print("Enter the number: ");
            number = Integer.parseInt(scanner.nextLine());
        } while (number < 0 || number >= 1000);
        String[] array = {"zero", "one", "two", "three", "Four", "five", "six", "seven", "eight", "nine", "ten"};
        String[] array1 = {"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"};
        String[] array2 = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        int num = number % 10;
        int num1 = number / 10;
        int num2 = (number / 10) % 10;
        int num3 = (number / 100);
        if (number <= 10) {
            System.out.print(array[number]);
        } else if (number < 20) {
            System.out.print(array1[number - 11]);
        } else if (number < 100) {
            if (num == 0) {
                System.out.println(array2[num1 - 2]);
            } else {
                System.out.println(array2[num1 - 2] + " " + array[num]);
            }
        } else {
            if (num2 >= 2 && num!=0) {
                System.out.println(array[num3] + " hundred " + array2[num2 - 2] + " " + array[num]);
            } else if (num2 >= 2 && num == 0) {
                System.out.println(array[num3] + " hundred " + array2[num2 - 2]);
            } else if (num2 == 0 && num == 0) {
                System.out.println(array[num3] + " hundred");
            } else if (num2 == 0 && num != 0) {
                System.out.println(array[num3] + " hundred and " + array[num]);
            } else if (num2 == 1 && num != 0) {
                System.out.println(array[num3] + " hundred " + array1[num - 1]);
            } else if (num2 == 1 && num == 0) {
                System.out.println(array[num3] + " hundred and ten");
            }
        }
    }
}