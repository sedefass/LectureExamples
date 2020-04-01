package design_patterns.a_creational.factory;

public class ShapeFactory {

    public Shape getShape(Shape.ShapeType shapeType) {

        if (Shape.ShapeType.TRIANGLE.equals(shapeType)) {
            return new Triangle(3, 4, 5);
        }

        if (Shape.ShapeType.RECTANGLE.equals(shapeType)) {
            return new Rectangle(3, 4);
        }

        if (Shape.ShapeType.SQUARE.equals(shapeType)) {
            return new Square(5);
        }

        return null;
    }

}
