package ss3_arrays_and_methods_in_java.Execises;

import java.util.Scanner;

public class CountCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str = scanner.nextLine();
        System.out.print("Enter character: ");
        char character = scanner.nextLine().charAt(0);
        int count = 0;
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (character == ch[i]) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No character in the string are the same as the characters you just entered");
        } else {
            System.out.println("String has " + count + " characters like the one you just entered!!!");
        }
    }
}
