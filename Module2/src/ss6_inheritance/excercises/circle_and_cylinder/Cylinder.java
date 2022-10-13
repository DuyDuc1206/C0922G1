package ss6_inheritance.excercises.circle_and_cylinder;

public class Cylinder extends Circle {
    private double height;


    public Cylinder(double height, double radius, String color) {
        super(radius, color);
        this.height = height;
    }

    public Cylinder() {
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return Math.PI * Math.pow(getRadius(), 2) * this.height;
    }

    public String toString() {
        return "A cylinder width height = "
                + getHeight()
                + " and volume = "
                + getVolume()
                + " , which is a subclass of "
                + super.toString();
    }
}
