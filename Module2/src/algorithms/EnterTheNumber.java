package algorithms;

import java.util.Scanner;

public class EnterTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num;
        while (true) {
            System.out.println("Enter the integer number");
            num = scanner.nextLine();
            try {
                CheckUtil.checkNumber(num);
                break;
            } catch (FormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
