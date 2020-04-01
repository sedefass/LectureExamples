package oop.d_abstraction;

public class Button implements OnClickListener {

    private String color;
    private String text;
    private double width;
    private double height;

    public Button(String color, String text, double width, double height) {
        this.color = color;
        this.text = text;
        this.width = width;
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void onClick() {
        System.out.println("Button has been JUST clicked");
    }
}
