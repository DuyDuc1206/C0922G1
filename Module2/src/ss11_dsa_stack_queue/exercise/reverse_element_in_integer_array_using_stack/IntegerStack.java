package ss11_dsa_stack_queue.exercise.reverse_element_in_integer_array_using_stack;

import case_study.service.IEmployeeService;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class IntegerStack {
    public static void main(String[] args) {
        Stack<Integer> wStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int size = Integer.parseInt(scanner.nextLine());
        int[] mWord = new int[size];
        for (int i = 0; i <size ; i++) {
            System.out.println("Enter the value of " + (i+1) );
            int word = Integer.parseInt(scanner.nextLine());
            wStack.push(word);
        }
        System.out.println(wStack);
        for (int i = size-1; i >=0 ; i--) {
            mWord[i]=wStack.pop();
        }
        System.out.println(Arrays.toString(mWord));
    }
}
