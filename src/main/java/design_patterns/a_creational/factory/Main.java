package design_patterns.a_creational.factory;

public class Main {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape triangle = shapeFactory.getShape(Shape.ShapeType.TRIANGLE);
        System.out.println(triangle.getType());
        System.out.println(triangle.calculateArea());
        System.out.println();

        Shape rectangle = shapeFactory.getShape(Shape.ShapeType.RECTANGLE);
        System.out.println(rectangle.getType());
        System.out.println(rectangle.calculateArea());
        System.out.println();

        Shape square = shapeFactory.getShape(Shape.ShapeType.SQUARE);
        System.out.println(square.getType());
        System.out.println(square.calculateArea());
        System.out.println();

    }

}
