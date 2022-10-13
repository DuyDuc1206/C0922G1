package ss6_inheritance.excercises.triangle;

public class Triangle extends Shape {
    private int side1 = 1;
    private int side2 = 1;
    private int side3 = 1;

    public Triangle() {
    }

    public Triangle(int side1, int side2, int side3, String color) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public float getSide1() {
        return side1;
    }

    public void setSide1(int side1) {
        this.side1 = side1;
    }

    public float getSide2() {
        return side2;
    }

    public void setSide2(int side2) {
        this.side2 = side2;
    }

    public float getSide3() {
        return side3;
    }

    public void setSide3(int side3) {
        this.side3 = side3;
    }

    public float getPerimeter() {
        return this.side1 + this.side2 + this.side3;
    }

    public double getArea() {
        double p = (0.5 * getPerimeter());
        double a = (0.5 * getPerimeter() - this.side1);
        double b = (0.5 * getPerimeter() - this.side2);
        double c = (0.5 * getPerimeter() - this.side3);
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public String toString() {
        return "Triangle with color: "
                + getColor()
                + ", side 1: "
                + this.side1
                + ", side 2: "
                + this.side2
                + ", side 3: "
                + this.side3
                + ", Area: "
                + getArea()
                + ", Perimeter: "
                + getPerimeter();
    }
}
