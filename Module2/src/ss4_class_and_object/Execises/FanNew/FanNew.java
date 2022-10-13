package ss4_class_and_object.Execises.FanNew;

public class FanNew {
    private final int SLOW = 1;
    private final int MEDIUM = 2;
    private final int FAST = 3;
    private int speed = SLOW;
    private boolean on ;
    private double radius = 5;
    private String color = "blue";
    public FanNew(){

    }

    public FanNew(int speed, double radius, String color, boolean on) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "{" +
                " speed=" + speed +
                ", radius=" + radius +
                ", color=" + color +
                ", on=" + on  +
                '}';
    }
}
