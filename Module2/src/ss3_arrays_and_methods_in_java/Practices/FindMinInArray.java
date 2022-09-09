package ss3_arrays_and_methods_in_java.Practices;

public class FindMinInArray {
    public static void main(String[] args) {
        int[] arr = {4, 7, 8, 6, 5, 4, 3};
        int index = minValue(arr);
        System.out.println("The smallest elemnt in the array is: " +arr[index]);
    }

    static int minValue(int[] array) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < array[index]) {
                index = i;
            }
        }
        return index;
    }
}
