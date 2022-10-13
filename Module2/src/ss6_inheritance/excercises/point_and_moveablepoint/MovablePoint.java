package ss6_inheritance.excercises.point_and_moveablepoint;

import java.util.Arrays;

public class MovablePoint extends Point{
    private float xSpeed;
    private float ySpeed;
    public MovablePoint(){

    }
    public MovablePoint(float xSpeed, float ySpeed){
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;
    }
    public MovablePoint(float x, float y, float xSpeed, float ySpeed){
        super(x, y);
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;
    }
    public float getXSpeed(){
        return this.xSpeed;
    }
    public void setXSpeed(float xSpeed){
        this.xSpeed=xSpeed;
    }
    public float getYSpeed(){
        return this.ySpeed;
    }
    public void setYSpeed(float ySpeed){
        this.ySpeed=ySpeed;
    }
    public void setSpeed(float xSpeed, float ySpeed){
        this.setXSpeed(xSpeed);
        this.setYSpeed(ySpeed);
    }
    public float[] getSpeed(){
        return new float[]{this.getXSpeed(),this.getYSpeed()};
    }
    public String toString(){
        return super.toString() + " , speed = " + Arrays.toString(getSpeed());
    }
    public MovablePoint move(){
        setX(getX()+getXSpeed());
        setY(getY()+getYSpeed());
        return this;
    }

}
