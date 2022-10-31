package ss18_string_regex.exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateClassName {
    private static final String CLASSNAME_REGEX = "[CAP][0-9]{4}[GHIKLM]";
    public static void main(String[] args) {
        System.out.print("Enter the class name: ");
        Scanner scanner = new Scanner(System.in);
        String className = scanner.nextLine();
        System.out.println("Class name is " + className + " is valid: " + className.matches(CLASSNAME_REGEX));
    }
}
