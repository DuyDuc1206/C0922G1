package ss4_class_and_object.Execises.FanNew;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import sun.nio.cs.FastCharsetProvider;

import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

public class Main {
    public static void main(String[] args) {
        FanNew fan1 = new FanNew(3, 10, "yellow", true);
        FanNew fan2 = new FanNew(0, 5, "blue", false);
        System.out.println("Chọn quạt bạn muốn xem: quạt 1 hoặc 2");
        Scanner scanner = new Scanner(System.in);
        int n;
        do {
            System.out.print("Choice: ");
            n = Integer.parseInt(scanner.nextLine());
            switch (n) {
                case 1:
                    System.out.println("Fan1: " + fan1);
                    break;
                case 2:
                    System.out.println("Fan2: " + fan2);
                    break;
            }
        } while (n < 1 || n > 2);
        System.out.println("Enter the properties you want to change: ");
        System.out.println("1. Turn on (true) ");
        System.out.println("2. Turn off (false) ");
        int n1 = Integer.parseInt(scanner.nextLine());
        switch (n1){
            case 1:
                System.out.println("Enter the speed you want to change: ");
                int n2 = Integer.parseInt(scanner.nextLine());
                fan2.setSpeed(n2);
                fan2.setOn(true);
                System.out.println("Fan2: " + fan2.toString());
                break;
            case 2:
                fan1.setSpeed(0);
                fan1.setOn(false);
                System.out.println("Fan1: " + fan1.toString());
        }
    }
}
