package oop.b_encapsulation;

import java.util.ArrayList;
import java.util.List;

public class PointB {

    private List<Double> coords = new ArrayList<>();

    public PointB(double x, double y) {
        this.coords.add(x);
        this.coords.add(y);
    }

    public double getX() {
        return coords.get(0);
    }

    public void setX(double x) {
        coords.set(0, x);
    }

    public double getY() {
        return coords.get(1);
    }

    public void setY(double y) {
        coords.set(1, y);
    }
}
