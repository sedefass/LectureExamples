package oop.c_inheritance.shapes;

public class Triangle extends Shape {

    private double a;
    private double b;
    private double c;

    // talk about this and super
    public Triangle(double a, double b, double c) {
        // VALIDATIONS
        super(ShapeType.TRIANGLE);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    // Show how we can override getType

    @Override
    public double calculateArea() {
        double p = 0.5 * (a + b + c);
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));  // Heron's Formula
    }
}
