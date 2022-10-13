package ss7_abstract_and_interface.excersice.interface_resizable_for_circle_classes;

import ss6_inheritance.practices.system_of_geometric_objects.Circle;
import ss6_inheritance.practices.system_of_geometric_objects.Rectangle;
import ss6_inheritance.practices.system_of_geometric_objects.Square;

public class Test implements Resizable {
    @Override
    public void resize(double percent) {
        Circle circle = new Circle();
        circle.setRadius(circle.getRadius() * percent + circle.getRadius());
        System.out.println(circle.toString());
        Rectangle rectangle = new Rectangle();
        rectangle.setLength(rectangle.getLength() * percent + rectangle.getLength());
        rectangle.setWidth(rectangle.getWidth() * percent + rectangle.getWidth());
        System.out.println(rectangle.toString());
        Square square = new Square();
        square.setSide(square.getSide() * percent + square.getSide());
        System.out.println(square.toString());
    }
}
