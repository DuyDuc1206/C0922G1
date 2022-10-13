package ss6_inheritance.excercises.point_and_moveablepoint;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(5,2);
        System.out.println(point);
        point.setXY(20,30);
        System.out.println(point);
        MovablePoint movablePoint = new MovablePoint(point.getX(),point.getY(),6,8);
        System.out.println(movablePoint);
        System.out.println(movablePoint.move());
        movablePoint.setSpeed(10,10);
        System.out.println(movablePoint);
        System.out.println(movablePoint.move());
    }
}
