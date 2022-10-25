package ss14_sort_algorithms.execises;

import java.util.Arrays;
import java.util.Scanner;

public class InsertSortIllustration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the length array");
        int number = Integer.parseInt(scanner.nextLine());
        int[] array = new int[number];
        for (int i = 0; i <number ; i++) {
            System.out.println("Enter the element at position " + (i+1));
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println(Arrays.toString(array));
        insertSort(array);
        System.out.println(Arrays.toString(array));

    }
    public static void insertSort(int[] list){
        for (int i = 1; i < list.length; i++) {
            int key = list[i];
            int j;
            for (j = i - 1; j >= 0 && list[j] > key; j--) {
                list[j + 1] = list[j];
            }
            list[j + 1] = key;
        }
    }
}
