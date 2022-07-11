package oop.c_inheritance;

import oop.c_inheritance.shapes.Rectangle;
import oop.c_inheritance.shapes.Square;
import oop.c_inheritance.shapes.Triangle;

public class Main {

    public static void main(String[] args) {
//        Shape shape = new Shape(); // Abstract classes cannot be instantiated

        Triangle triangle = new Triangle(3, 4, 5);
        System.out.println(triangle.getType());
        System.out.println(triangle.calculateArea());
        System.out.println();

        Rectangle rectangle = new Rectangle(3, 4);
//        Rectangle rectangleNope = new Rectangle(Shape.ShapeType.SQUARE, 3, 4); // because this constructor is protected
        System.out.println(rectangle.getType());
        System.out.println(rectangle.calculateArea());
        System.out.println(rectangle.calculateDiagonal());
        System.out.println();


        Square square = new Square(5);
        System.out.println(square.getType());
        System.out.println(square.calculateArea());
        System.out.println();

        square.setA(6);
        System.out.println(square.getType());
        System.out.println(square.calculateArea());
        System.out.println(square.calculateDiagonal());
        System.out.println();
        square.setB(7);
        System.out.println(square.getType());
        System.out.println(square.calculateArea());
        System.out.println();
    }

}
