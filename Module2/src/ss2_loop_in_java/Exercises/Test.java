package ss2_loop_in_java.Exercises;


public class Test {
    public static void main(String[] args) {
        for (int i = 2; i <= 6; i++) {
            for (int j = 1; j < 2 * 6; j++) {
                if (Math.abs(6 - j) == (i - 1)) {
                    System.out.print((i - 1));
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (int i = 5; i > 1; i--) {
            for (int j = 1; j < 2 * 6; j++) {
                if (Math.abs(6 - j) == (i - 1)) {
                    System.out.print((i - 1));
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
