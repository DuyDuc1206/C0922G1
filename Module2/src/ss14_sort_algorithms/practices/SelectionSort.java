package ss14_sort_algorithms.practices;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        int[] list = { 1,5,9,8,7};
        System.out.println(Arrays.toString(list));
        selectionSort(list);
        System.out.println(Arrays.toString(list));
//        System.out.println("enter the number elements of array");
//        Scanner scanner = new Scanner(System.in);
//        int numb = Integer.parseInt(scanner.nextLine());
//        int[] array = new int[numb];
//        for (int i = 0; i <numb ; i++) {
//            System.out.println("Enter the element position "+ (i+1));
//            array[i] = Integer.parseInt(scanner.nextLine());
//        }
//        System.out.println(Arrays.toString(array));
//        selectionSort(array);
//        System.out.println(Arrays.toString(array));
    }

    public static void selectionSort(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j]<list[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex!=i){
                int temp = list[minIndex];
                list[minIndex] = list[i];
                list[i] = temp;
            }
        }
    }
}
