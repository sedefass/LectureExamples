package oop.b_encapsulation;

public class PointC {

    private double x;  // setter with validation
    private double y;  // only getter

    public PointC(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = (x < 0) ? 0 : x;
    }

    public double getY() {
        return y;
    }


}
