package ss6_inheritance.excercises.point2D_and_point3D;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(2,4);
        System.out.println(point2D);
        Point3D point3D = new Point3D(5,8,8);
        System.out.println(point3D);
        System.out.println(Arrays.toString(point3D.getXYZ()));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the x: ");
        float x = Float.parseFloat(scanner.nextLine());
        System.out.println("Enter the y: ");
        float y = Float.parseFloat(scanner.nextLine());
        System.out.println("Enter the z: ");
        float z = Float.parseFloat(scanner.nextLine());
        point2D.setX(x);
        point2D.setY(y);
        point3D.setZ(z);
        point2D.setXY(x,y);
        point3D.setXYZ(x,y,z);
        System.out.println(Arrays.toString(point2D.getXY()));
        System.out.println(Arrays.toString(point3D.getXYZ()));
    }
}
