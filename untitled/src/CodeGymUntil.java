import java.util.Scanner;

public class CodeGymUntil {
    private static final Scanner sc = new Scanner(System.in);

    public static boolean isValidClassName() throws InvalidFormatCGNameException {
        System.out.println("Enter the class name");
        String str = sc.nextLine();
        boolean check = str.matches("C[0-9]{2}2[0-9]G[0-9]");
        if (!check) {
            throw new InvalidFormatCGNameException("Wrong format exception ");
        } else {
            return true;
        }
    }
}
