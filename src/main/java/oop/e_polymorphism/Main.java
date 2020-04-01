package oop.e_polymorphism;

import oop.c_inheritance.shapes.Rectangle;
import oop.c_inheritance.shapes.Shape;
import oop.c_inheritance.shapes.Square;
import oop.c_inheritance.shapes.Triangle;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Triangle triangle = new Triangle(3, 4, 5);
        Rectangle rectangle = new Rectangle(3, 4);
        Square square = new Square(5);

        List<Shape> shapes = new ArrayList<>();  // talk about new LinkedList(), new List() and the idea to use the interface List
        shapes.add(triangle);
        shapes.add(rectangle);
        shapes.add(square);
        printAreas(shapes);

        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(rectangle);
        rectangles.add(square);
        printAreasGeneric(rectangles);  // Show this does not work but how we can fix it
//        rectangles.add(triangle);
    }

    // Create a generic method that works with shapes
    public static void printAreas(List<Shape> shapes) {
        for (Shape shape: shapes) {
            System.out.println(shape.calculateArea());
        }
    }

    public static <T extends Shape> void printAreasGeneric(List<T> shapes) {
        for (Shape shape: shapes) {
            System.out.println(shape.calculateArea());
        }
    }

}
