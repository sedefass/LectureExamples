package oop.c_inheritance.shapes;

public class Square extends Rectangle {

    public Square(double side) {
        super(ShapeType.SQUARE, side, side);
    }

    @Override
    public void setA(double side) {
        super.setA(side);
        super.setB(side);
    }

    @Override
    public void setB(double side) {
        super.setA(side);
        super.setB(side);
    }

//    @Override
//    @Deprecated
//    public void setB(double side) throws UnsupportedOperationException {
//        throw new UnsupportedOperationException("Man, you are not supposed to use this method, come on!");
//    }

    // No need to override calculateArea()

    // No need to override calculateDiagonal()
}
