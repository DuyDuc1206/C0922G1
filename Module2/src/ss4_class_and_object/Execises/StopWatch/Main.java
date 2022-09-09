package ss4_class_and_object.Execises.StopWatch;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter: ");
        System.out.println("1. Start time");
        System.out.println("2. End time");
        System.out.println("Enter your choice");
        StopWatch stopWatch = new StopWatch();
        for (int i = 0; ; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            if (n == 1) {
                System.out.println("Start time: " + stopWatch.start());
                continue;
            }
            if (n == 2) {
                System.out.println("End time: " + stopWatch.stop());
                System.out.println("Elapsed time: " + stopWatch.getElapsedTime());
                break;
            }
            if (n != 1 || n != 2) {
                System.out.println("Re-enter");
            }
        }
    }
}
