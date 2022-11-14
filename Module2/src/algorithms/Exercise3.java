package algorithms;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number");
        int number = Integer.parseInt(scanner.nextLine());
        System.out.print("Dãy số nguyên tố và fibonacci là: ");
        isFibonacci(number);
    }

    public static void isFibonacci(int n) {
        int n1 = 0;
        int n2 = 1;
        int sum = 0;
        int count =0;
        List<Integer> arrayList = new ArrayList<>(n + 1);
        arrayList.add(0);
        for (int i = 0; i < n; i++) {
            if (sum <= n) {
                sum = n1 + n2;
                arrayList.add(n2);
                n1 = n2;
                n2 = sum;
            }
        }
//        System.out.println(arrayList.toString());
        for (int i = 3; i <arrayList.size() ; i++) {
            for (int j = 1; j <=arrayList.get(i) ; j++) {
                if(arrayList.get(i)%j==0){
                    count++;
                }
            } if(count==2){
                System.out.print( arrayList.get(i) + " ");
            }
            count=0;
        }
    }
}
