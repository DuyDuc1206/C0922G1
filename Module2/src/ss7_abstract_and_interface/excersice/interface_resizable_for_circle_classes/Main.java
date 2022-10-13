package ss7_abstract_and_interface.excersice.interface_resizable_for_circle_classes;

import ss6_inheritance.practices.system_of_geometric_objects.Circle;
import ss6_inheritance.practices.system_of_geometric_objects.Rectangle;
import ss6_inheritance.practices.system_of_geometric_objects.Square;

public class Main {
    public static void main(String[] args) {
        Test test =new Test();
        System.out.println("Pre_change:");
        Circle circle = new Circle();
        System.out.println(circle.toString());
        Rectangle rectangle =new Rectangle();
        System.out.println(rectangle.toString());
        Square square = new Square();
        System.out.println(square.toString());
        System.out.println("After_change");
        double percent = (Math.random()*100)/100;
        test.resize(percent);
    }
}
