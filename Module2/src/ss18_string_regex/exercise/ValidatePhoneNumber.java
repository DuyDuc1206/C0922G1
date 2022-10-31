package ss18_string_regex.exercise;

import java.util.Scanner;

public class ValidatePhoneNumber {
    private static final String PHONENUMBER_REGEX = "[0-9]{2}[-][0][0-9]{9}";

    public static void main(String[] args) {
        System.out.print("Enter the phone number: ");
        Scanner scanner = new Scanner(System.in);
        String className = scanner.nextLine();
        System.out.println("Class name is " + className + " is valid: " + className.matches(PHONENUMBER_REGEX));
    }
}
