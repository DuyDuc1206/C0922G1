package ss1_Introduction_to_java.Practices;

import java.util.Scanner;

public class BodyMass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your weight (kilometer) : ");
        double weight = scanner.nextFloat();
        System.out.print("Enter your height (meter): ");
        double height = scanner.nextFloat();
        double bmi = (weight / Math.pow(height, 2));
        if (bmi < 18.5) {
            System.out.printf("BMI = %f, You are underweight", bmi);
        } else if (bmi < 25) {
            System.out.printf("BMI = %f,You are normal", bmi);
        } else if (bmi < 30) {
            System.out.printf("BMI = %f,You are overweight", bmi);
        } else {
            System.out.printf("BMI = %f,You are obese", bmi);
        }
    }
}
