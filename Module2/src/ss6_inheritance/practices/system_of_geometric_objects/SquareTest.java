package ss6_inheritance.practices.system_of_geometric_objects;

import ss6_inheritance.practices.system_of_geometric_objects.Square;

public class SquareTest {
    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square);
        square =new Square(2.3);
        System.out.println(square);
        square = new Square(4.5,"pink",false);
        System.out.println(square);
        System.out.println(square.getPerimeter());
    }
}
