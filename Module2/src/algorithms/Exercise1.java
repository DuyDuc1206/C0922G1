package algorithms;

import javax.swing.plaf.IconUIResource;
import java.util.Scanner;

//Viết 1 hàm nhận vào 1 số nguyên bất kì.
// Hiển thị các số KHÔNG phải số nguyên tố từ 0 đến số đấy.
public class Exercise1 {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the integer number");
        int number = Integer.parseInt(sc.nextLine());
        isInteger(number);
    }

//    public static void findNotInteger(int n) {
//        System.out.print("Các số không phải là số nguyên tố là: ");
//        int[] arr = new int[n + 1];
//        int count = 0;
//        for (int i = 0; i <= n; i++) {
//            arr[i] = i;
//        }
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 1; j <= arr[i]; j++) {
//                if (arr[i] % j == 0) {
//                    count++;
//                }
//            }
//            if (count == 2) {
//                System.out.print(i + " ");
//            }
//            count = 0;
//        }
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 1; j <= arr[i]; j++) {
//                if (arr[i] % j == 0) {
//                    count++;
//                }
//            }
//            if (count != 2) {
//                System.out.print(i+ " ");
//            }
//            count = 0;
//        }
    public static void isInteger(int n){
        System.out.println("cac so la so nguyen to la");
        int[] arr = new int[n+1];
        int count=0;
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 1; j <=i ; j++) {
                if(i%j ==0){
                    count++;
                }
            }
            if(count==2){
                System.out.println(i + " ");
            }
            count =0;
        }

    }
}
