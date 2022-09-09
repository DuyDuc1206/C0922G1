package ss4_class_and_object.Execises.QuadraticEquation;

public class QuadraticEquation {
    double a, b, c, delta, r1, r2;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminant() {
        return delta = Math.pow(this.b, 2) - 4 * this.a * this.c;
    }

    public double getRoot1() {
        return r1 = (-this.b + Math.sqrt(this.b * this.b - 4 * this.a * this.c)) / (2 * this.a);
    }

    public double getRoot2() {
        return r2 = (-this.b - Math.sqrt(this.b * this.b - 4 * this.a * this.c)) / (2 * this.a);
    }
}
