package ss6_inheritance.practices.system_of_geometric_objects;

import ss6_inheritance.practices.system_of_geometric_objects.Rectangle;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);
        rectangle = new Rectangle(1,2);
        System.out.println(rectangle);
        rectangle = new Rectangle(2,4,"yellow",false);
        System.out.println(rectangle);
    }
}
