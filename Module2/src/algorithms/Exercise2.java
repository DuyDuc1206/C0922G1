package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Exercise2 {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the length of array");
//        int[] array = new int[num];
//        count(array);
        List<Integer> ar = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        int num = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < num; i++) {
            System.out.println("Enter the element at position " + (i + 1));
            ar.add(Integer.parseInt(sc.nextLine()));
        }
        System.out.println(ar);
        int count = 1;
        for (int i = 0; i < ar.size(); i++) {
            for (int j = i + 1; j < ar.size(); j++) {
                if (ar.get(i) == ar.get(j)) {
                    count++;
                    ar.remove(j);
                }
            }
            arr2.add(count);
            count = 1;
        }
        for (int i = 0; i < arr2.size(); i++) {
            System.out.println(ar.get(i) + " times " + arr2.get(i));
        }
//    public static void count(int[] arr){
//
//        }
    }
}
// Xóa phần tử;
//int[] A = {1,4,4,3,4};
//    int c = 0 ;
//    int k = 4;
//        for (int i = 0; i < 5; i++) {
//        if (A[i] != k) {
//            A[c] = A[i];
//            c++;
//        }
//    }
//        System.out.println("Mảng còn lại sau khi xóa phần tử " + k + " là: ");
//        for (int i = 0; i < c; i++) {
//        System.out.print(A[i] + "\t");
//    }
//}