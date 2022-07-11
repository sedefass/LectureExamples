package oop.b_encapsulation;

public class PointB {

    private Double[] coords = new Double[2];

    public PointB(double x, double y) {
        this.coords[0] = x;
        this.coords[1] = y;
    }

    public double getX() {
        return this.coords[0];
    }

    public void setX(double x) {
        this.coords[0] = x;
    }

    public double getY() {
        return this.coords[1];
    }

    public void setY(double y) {
        this.coords[1] = y;
    }
}
