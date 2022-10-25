package ss14_sort_algorithms.execises;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] list = {1, 9, 8, 0, 4, 8, 3};
        System.out.println(Arrays.toString(list));
        insertSort(list);
        System.out.println(Arrays.toString(list));
    }

    public static void insertSort(int[] list) {
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
