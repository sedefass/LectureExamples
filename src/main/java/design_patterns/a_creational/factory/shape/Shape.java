package design_patterns.a_creational.factory.shape;

public abstract class Shape {  // is Shape inheriting something

    private ShapeType type;

    public enum ShapeType {
        TRIANGLE,
        RECTANGLE,
        SQUARE
    }

    Shape(ShapeType type) {
        this.type = type;
    }

    public ShapeType getType() {
        return type;
    }

    // NOTE: There is NO type setter

    public abstract double calculateArea();
}
