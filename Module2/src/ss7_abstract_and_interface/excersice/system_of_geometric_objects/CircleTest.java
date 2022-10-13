package ss7_abstract_and_interface.excersice.system_of_geometric_objects;

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
