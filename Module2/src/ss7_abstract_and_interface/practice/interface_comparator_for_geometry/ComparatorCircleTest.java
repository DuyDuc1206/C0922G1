package ss7_abstract_and_interface.practice.interface_comparator_for_geometry;

import ss6_inheritance.practices.system_of_geometric_objects.Circle;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorCircleTest {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle(2);
        circles[1] = new Circle();
        circles[2] = new Circle(3.5,"blue",false);
        System.out.println("Pre_sort");
        for (Circle circle : circles){
            System.out.println(circle);
        }
        Comparator comparatorCircle = new ComparatorCircle();
        Arrays.sort(circles,comparatorCircle);
        System.out.println("After_sort");
        for (Circle circle: circles){
            System.out.println(circle);
        }


    }
}
