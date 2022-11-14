import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số: để tìm số chính phương nhỏ hơn chính nó");
        int number = Integer.parseInt(scanner.nextLine());
        System.out.print("Các số chính phương nhỏ hơn " + number + " là: ");
        laSoChinhPhuong(number);
    }

    public static void laSoChinhPhuong(int n) {
        for (int i = 2; i < n; i++) {
            for (int j = 2; j < n / 2; j++) {
                if (i == j * j) {
                    System.out.print(i + " ");
                }
            }
        }
    }
}
