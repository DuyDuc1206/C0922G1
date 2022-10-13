package ss6_inheritance.practices.system_of_geometric_objects;

import ss6_inheritance.practices.system_of_geometric_objects.Rectangle;
import ss7_abstract_and_interface.excersice.interface_colorable_for_geometry_classes.Colorable;

public class Square extends Rectangle {
    public Square(){

    }
    public Square(double side){
        super(side,side);
    }
    public Square(double side,String color,boolean filled){
        super(side,side,color,filled);
    }
    public double getSide(){
        return getWidth();
    }
    public void setSide(double side){
        setWidth(side);
        setLength(side);
    }
    public double getArea(){
        return this.getSide() * this.getSide();
    }
//    @Override
//    public void setWidth(double width) {
//        setSide(width);
//    }
//    @Override
//    public void setLength(double length) {
//        setSide(length);
//    }


    public String toString(){
        return "A square with side= "
                + getSide()
                + " , which is a subclass of "
                +super.toString();
    }
}
