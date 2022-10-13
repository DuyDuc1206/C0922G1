package ss6_inheritance.excercises.point_and_moveablepoint;

import java.util.Arrays;

public class Point {
    private float x;
    private float y;
    public Point(){

    }
    public Point(float x, float y){
        this.x=x;
        this.y=y;
    }
    public float getX(){
        return this.x;
    }
    public void setX(float x){
        this.x=x;
    }
    public float getY(){
        return this.y;
    }
    public void setY(float y){
        this.y=y;
    }
    public void setXY(float x, float y){
        this.setX(x);
        this.setY(y);
    }
    public float[] getXY(){
        return new float[]{this.getX(),this.getY()};
    }
    public String toString(){
        return Arrays.toString(getXY());
    }
}
