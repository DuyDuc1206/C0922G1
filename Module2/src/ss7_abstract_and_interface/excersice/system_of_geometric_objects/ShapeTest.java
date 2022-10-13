package ss7_abstract_and_interface.excersice.system_of_geometric_objects;

public class ShapeTest {
    public static void main(String[] args) {
        Shape shape = new Shape() {
            @Override
            public void getArea() {
            }
        };
        System.out.println(shape);
//        shape = new Shape("red",false);
//        System.out.println(shape);
    }
}
