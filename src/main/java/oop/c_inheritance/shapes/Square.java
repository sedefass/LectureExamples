package oop.c_inheritance.shapes;

public class Square extends Rectangle {

    public Square(double side) {
        super(ShapeType.SQUARE, side, side);
    }

    @Override
    public void setA(double side) {
        // NO NEED OF VALIDATIONS - they are in Rectangle
        super.setA(side);
        super.setB(side);
    }

    @Override
    @Deprecated
    public void setB(double side) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Man, you are not supposed to use this method, come on!");
    }

    // We do not override calculateArea()

    // We do not override calculateDiagonal()
}
