package ss7_abstract_and_interface.excersice.interface_colorable_for_geometry_classes;

import ss7_abstract_and_interface.excersice.system_of_geometric_objects.Rectangle;
import ss7_abstract_and_interface.excersice.system_of_geometric_objects.Shape;
import ss7_abstract_and_interface.excersice.system_of_geometric_objects.Square;

public class Main {
    public static void main(String[] args) {
        Shape[] squares = new Shape[3];
        squares[0] = new Square();
        squares[1] = new Rectangle(4, 5);
        squares[2] = new Square(5, "red", false);
        for (Shape i : squares) {
            System.out.print(i.toString() + " and Area: ");
            i.getArea();
            if (i instanceof Square) {
                ((Square) i).howToColor();
            }
        }
    }
}
