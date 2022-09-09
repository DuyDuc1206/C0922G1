package ss3_arrays_and_methods_in_java.Practices;

import com.sun.prism.shader.Texture_ImagePattern_AlphaTest_Loader;

import java.util.Scanner;

public class TemperatureConversionProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double fahrenheit;
        double celsius;
        int choice;
        do {
            System.out.println("Menu: ");
            System.out.println("1. Celsius to fahrenheit");
            System.out.println("2. Fahrenheit to celsius");
            System.out.println("0. Exist");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Enter celsius: ");
                    celsius = Double.parseDouble(scanner.nextLine());
                    System.out.println("Celsius to fahrenheit: " + celsiusToFahrenheit(celsius));
                    break;
                case 2:
                    System.out.print("Enter fahrenheit: ");
                    fahrenheit = Double.parseDouble(scanner.nextLine());
                    System.out.println("Celsius to fahrenheit: " + fahrenheitToCelsius(fahrenheit));
                    break;
                case 0:
                    System.exit(0);
            }

        } while (choice != 0);

    }

    public static double celsiusToFahrenheit(double celsius) {
        double fahrenheit = (9 / 5) * celsius + 32;
        return fahrenheit;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        double celsius = (fahrenheit - 32) * 5 / 9;
        return celsius;
    }
}
