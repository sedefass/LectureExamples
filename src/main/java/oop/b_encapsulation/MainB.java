package oop.b_encapsulation;

public class MainB {

    public static void main(String[] args) {
        PointA pointAex = new PointA(1, 2);

        PointA pointA = new PointA(1, 2);
        double xa = pointA.getX();
        double ya = pointA.getY();

        PointB pointB = new PointB(1, 2);
        double xb = pointB.getX();
        double yb = pointB.getY();

        assert(xa == xb);
        assert(ya == yb);
    }

}
