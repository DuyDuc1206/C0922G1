package ss6_inheritance.excercises.triangle;

public class Shape {
    private String color;
    private float width;
    private float length;

    public Shape() {

    }
    public Shape(String color){
        this.color=color;
    }

    public Shape(String color, float width, float length) {
        this.color = color;
        this.width = width;
        this.length = length;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }
}
