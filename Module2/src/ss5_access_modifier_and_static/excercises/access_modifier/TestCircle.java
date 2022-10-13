package ss5_access_modifier_and_static.excercises.access_modifier;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.println("Radius of circle is: " + circle.getRadius());
        System.out.print("Area of circle is: " + circle.getArea());
    }
}
