package ss15_exception.execises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IllegalTriangleException {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Integer> sideList = new ArrayList<>();
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            System.out.println("enter the side " + (i + 1));
            IllegalTriangleException.enterSide();
            sideList.add(i);
        }
        System.out.println(sideList);

    }

    public static void enterSide() {
        while (true) {
            try {
                int number = Integer.parseInt(scanner.nextLine());
                CheckException.checkSide(number);
                break;
            } catch (WrongInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
