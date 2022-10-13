package ss7_abstract_and_interface.excersice.system_of_geometric_objects;

public class SquareTest {
    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square);
        square =new Square(2.3);
        System.out.println(square);
        square = new Square(4.5,"pinnk",false);
        System.out.println(square);
        System.out.println(square.getPerimeter());
    }
}
