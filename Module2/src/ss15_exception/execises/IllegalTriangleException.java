package ss15_exception.execises;
import java.util.Scanner;

public class IllegalTriangleException {
    private static Scanner scanner = new Scanner(System.in);
    static int i = 1;
    public static void main(String[] args) {
        while (true) {
            int side1 = enterSide();
            int side2 = enterSide();
            int side3 = enterSide();
            try {
                CheckException.checkSumTwoSide(side1, side2, side3);
                System.out.println("These are three side of triangle");
                break;
            } catch (WrongInputException e) {
                i =1;
                System.out.println(e.getMessage());
                System.out.println("re-enter");
            }
        }
    }

    public static int enterSide() {
        while (true) {
            try {
                System.out.println("Enter the side " + i + " of triangle ");
                int number = Integer.parseInt(scanner.nextLine());
                CheckException.checkSide(number);
                i++;
                return number;
            } catch (WrongInputException e) {
                System.out.println(e.getMessage());
                System.out.println("Re-enter");
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Re-enter");
            }
        }
    }
}
