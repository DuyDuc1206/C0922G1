package ss14_sort_algorithms.practices;

import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] list = {1,5,4,3,9,8};
        System.out.println(Arrays.toString(list));
        bubbleSort(list);
        System.out.println(Arrays.toString(list));
    }

    public static void bubbleSort(int[] list) {
        boolean isSwap = true;
        for (int i = 1; i < list.length && isSwap; i++) {
            isSwap = false;
            for (int j = 0; j < list.length - i; j++) {
                if (list[j] > list[j + 1]) {
                    int temp = list[j];
                    list[j]=list[j+1];
                    list[j+1]=temp;
                    isSwap=true;
                }
            }
        }
    }
}
