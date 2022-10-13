package ss6_inheritance.practices.system_of_geometric_objects;

import ss6_inheritance.practices.system_of_geometric_objects.Circle;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);
        circle = new Circle(2);
        System.out.println(circle);
        circle = new Circle(5,"brown",false);
        System.out.println(circle);
    }
}
