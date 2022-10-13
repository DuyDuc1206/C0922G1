package ss7_abstract_and_interface.excersice.system_of_geometric_objects;

public class Circle extends Shape {
    private double radius = 1;
    public Circle(){

    }
    public Circle(double radius){
        this.radius=radius;
    }
    public Circle(double radius, String color, boolean filled){
        super(color, filled);
        this.radius=radius;
    }
    public double getRadius(){
        return this.radius;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public void getArea(){
        System.out.println(Math.PI * Math.pow(this.radius,2));;
    }
    public double getPerimeter(){
        return Math.PI * this.radius*2;
    }
    public String toString(){
        return "A Cirle with radius = "
                + getRadius()
                + " , which is a subclass of "
                + super.toString();
    }
}
