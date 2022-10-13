package ss6_inheritance.excercises.circle_and_cylinder;

public class Circle {
    private double radius;
    private String color;

    public Circle() {
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    public double getPerimeter() {
        return Math.PI * this.radius * 2;
    }

    public String toString() {
        return "A circle width radius = "
                + getRadius()
                + " , area = "
                + getArea()
                + " , perimeter = "
                + getPerimeter()
                + " and color: "
                + getColor();
    }
}
