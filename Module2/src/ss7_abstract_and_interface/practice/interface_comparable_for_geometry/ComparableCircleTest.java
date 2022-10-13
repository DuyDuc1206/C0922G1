package ss7_abstract_and_interface.practice.interface_comparable_for_geometry;

import java.util.Arrays;
import java.util.Comparator;

public class ComparableCircleTest {
    public static void main(String[] args) {
        ComparableCircle[] comparableCircles = new ComparableCircle[3];
        comparableCircles[0] = new ComparableCircle(3.6);
        comparableCircles[1] = new ComparableCircle();
        comparableCircles[2] = new ComparableCircle(2,"red",false);
        System.out.println("Pre_sort");
        for (ComparableCircle comparableCircle : comparableCircles){
            System.out.println(comparableCircle);
        }
        Arrays.sort(comparableCircles);
        System.out.println("After_sort");
        for (ComparableCircle comparableCircle : comparableCircles){
            System.out.println((comparableCircle));
        }
    }
}
