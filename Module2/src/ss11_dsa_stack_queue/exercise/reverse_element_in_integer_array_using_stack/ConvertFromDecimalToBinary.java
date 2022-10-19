package ss11_dsa_stack_queue.exercise.reverse_element_in_integer_array_using_stack;

import java.util.Scanner;
import java.util.Stack;

public class ConvertFromDecimalToBinary {
    public static void main(String[] args) {
        Stack<Integer> convert = new Stack<>();
        System.out.print("Enter the Decimal number to convert: ");
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        while (number > 0) {
            convert.push(number % 2);
            number /= 2;
        }
//        System.out.println(convert);
        System.out.print("-> Binary: ");
        while (!convert.isEmpty()) {
            System.out.print(convert.pop());
        }
//        System.out.println("");
//        System.out.println("------------------------------------");
//        System.out.print("Enter the Binary number to convert:11011 ");
//        double number1 = Double.parseDouble(scanner.nextLine());
//        String string = String.valueOf(number1);
//        char[] array = string.toCharArray();
//        for (int i = 0; i <array.length ; i++) {
//            int temp1 = array.length - i;
//            int temp2 = temp1 -1;
//            (array[i]) * Math.pow(2,temp1) = array[i +1] * Math.pow(2,temp2);
//        }
    }
}
