package ss14_sort_algorithms.practices;

import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] list = {1, 5, 4, 11, 9, 8};
        System.out.println(Arrays.toString(list));
//        bubbleSort(list);
        selectSort(list);
        System.out.println(Arrays.toString(list));
    }

    public static void bubbleSort(int[] list) {
        boolean isSwap = true;
        for (int i = 0; i < list.length - 1 && isSwap; i++) {
            isSwap = false;
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j] > list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    isSwap = true;
                }
            }
        }
    }

    public static void selectSort(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = list[minIndex];
                list[minIndex] = list[i];
                list[i] = temp;
            }
        }
    }
    public static void insertSort(int[] list){
        
    }
}
