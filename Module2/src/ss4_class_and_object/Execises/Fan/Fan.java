package ss4_class_and_object.Execises.Fan;

import org.omg.PortableInterceptor.INACTIVE;

public class Fan {
    int speed;
    double radius = 5;
    String color = "blue";
    boolean on = true;
    static int SLOW = 1;
    static int MEDIUM = 2;
    static int FAST = 3;

    public Fan() {

    }

    public Fan(int speed, double radius, String color, boolean on) {
        this.color = color;
        this.radius = radius;
        this.on = on;
        this.speed = speed;
    }
    public  void setColor(String color){
        this.color = color;
    }
    public void setRadius(int radius){
        this.radius = radius;
    }
    public void setOn(boolean on){
        this.on = on;
    }
    private double getRadius() {
        return this.radius;
    }

    private String getColor() {
        return this.color;
    }

    private boolean isTurn() {
//        this.on = true;
        return this.on;
    }

    private int getSpeed() {
        return this.speed;
    }

    public String display() {
        return "Fan{" +
                "speed=" + speed +
                ", radius=" + radius +
                ", color='" + color + '\'';
    }
}
