package ss6_inheritance.practices.system_of_geometric_objects;

import ss6_inheritance.practices.system_of_geometric_objects.Shape;

public class ShapeTest {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println(shape);
        shape = new Shape("red",false);
        System.out.println(shape);
    }
}
