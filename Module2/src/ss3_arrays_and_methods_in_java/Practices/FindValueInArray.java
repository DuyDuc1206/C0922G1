package ss3_arrays_and_methods_in_java.Practices;

import java.util.Arrays;
import java.util.Scanner;

public class FindValueInArray {
    public static void main(String[] args) {
        String[] arr = {"neymar", "messi", "ronaldo", "cacilas", "kroos"};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name of soccer player: ");
        String str = scanner.nextLine();
        boolean isExit = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(str)) {
                System.out.println("The name of the player you entered is on the list of player participating in the competition and at position " + (i + 1));
                isExit = true;
                break;
            }
        }
        if (!isExit) {
            System.out.println("The name of the player you entered isn't on the list of player participating in the competition!!!");
        }
    }
}
