package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i <n ; i++) {
            int a =i;
            for (int j = 0; j <=i ; j++) {
                if (j==0 || j==a){
                    System.out.print("*");
                }
                System.out.print("  ");
            }
            System.out.println();
        }
        for (int i = 1; i <n ; i++) {
            int a =i;
            for (int j = n-1; j >=i ; j--) {
                if (j==a || j==n-1){
                    System.out.print("*");
                }
                System.out.print("  ");
            }
            System.out.println();
        }
    }
}

// System.out.println("*");
//        for (int i = 0; i <n-1 ; i++) {
//            System.out.print("*");
//            for (int j = 0; j <=i ; j++) {
//                System.out.print("  ");
//            }
//            System.out.println("*");
//        }
//        for (int i = n-1; i >=0 ; i--) {
//            System.out.print("*");
//            for (int j = i; j >=0 ; j--) {
//                System.out.print("  ");
//            }
//            System.out.println("*");
//        }
//        System.out.println("*");
