package design_patterns.a_creational.factory;

public class Rectangle extends Shape {

    private double a;
    private double b;

    public Rectangle(double a, double b) {
        // VALIDATIONS
        super(ShapeType.RECTANGLE);
        this.a = a;
        this.b = b;
    }

    Rectangle(ShapeType type, double a, double b) {  // it can be also default
        super(type);
        this.a = a;
        this.b = b;
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

    @Override
    public double calculateArea() {
        return a * b;
    }

    public double calculateDiagonal() {
        return Math.sqrt(a * a + b * b);
    }

}
