package oop.e_polymorphism;

import oop.c_inheritance.shapes.Rectangle;
import oop.c_inheritance.shapes.Shape;
import oop.c_inheritance.shapes.Square;
import oop.c_inheritance.shapes.Triangle;
import oop.d_abstraction.*;
import oop.d_abstraction.Button;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Triangle triangle = new Triangle(3, 4, 5);
        Rectangle rectangle = new Rectangle(3, 4);
        Square square = new Square(5);

        Shape rectangle2 = new Rectangle(3, 4);
        ((Rectangle)rectangle2).calculateDiagonal();

        List<Shape> shapes = new ArrayList<>();  // talk about new LinkedList(), new List() and the idea to use the interface List
        shapes.add(triangle);
        shapes.add(rectangle);
        shapes.add(square);
        printAreas(shapes);

        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(rectangle);
        rectangles.add(square);
//        rectangles.add(triangle);
//        rectangles.add(rectangle2);
//        printAreas(rectangles);
        printAreasGeneric(rectangles);  // Show this does not work but how we can fix it

        List<Square> squares = new ArrayList<>();
        squares.add(square);
        printAreasGeneric(squares);
//        squares.add(triangle);
//        squares.add(rectangle);

        // TODO !!! interfaces discussion !!!

        List<OnClickListener> clickListeners = new ArrayList<>();
        clickListeners.add(new Button("blue", "Login", 120, 30));
        clickListeners.add(new TextView("OOP is in the ba...", new Font("", 1, 1) , 120, 60));
        clickListeners.add(() -> System.out.println("My custom implementation has been HORIZONTALLY swiped"));

        List<OnSwipeListener> swipe = new ArrayList<>();
        swipe.add(new OnSwipeListener() {  // Anonymous class implementation of OnSwipeListener interface

            private String hehe = "hehe it works ;) ";

            @Override
            public void onVerticalSwipe() {
                System.out.println(hehe +  "My custom implementation has been VERTICALLY swiped");
            }

            @Override
            public void onHorizontalSwipe() {
                System.out.println("My custom implementation has been HORIZONTALLY swiped");
            }
        });

        clickListeners.forEach(OnClickListener::onClick);
    }

    // Create a generic method that works with shapes
    public static void printAreas(List<Shape> shapes) {
        for (Shape shape: shapes) {
            System.out.println(shape.calculateArea());
        }
        System.out.println("----");
    }

    public static <T extends Shape> void printAreasGeneric(List<T> shapes) {
        for (Shape shape: shapes) {
            System.out.println(shape.calculateArea());
        }
        System.out.println("----");
    }

}
