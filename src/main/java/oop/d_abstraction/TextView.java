package oop.d_abstraction;

import java.awt.*;

public class TextView implements OnClickListener, OnSwipeListener {

    private String text;
    private Font font;
    private double width;
    private double length;

    public TextView(String text, Font font, double width, double length) {
        this.text = text;
        this.font = font;
        this.width = width;
        this.length = length;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public void onClick() {
        this.text = "";
        System.out.println("TextView has been JUST clicked");
    }

    @Override
    public void onVerticalSwipe() {
        System.out.println("TextView has been VERTICALLY swiped");
    }

    @Override
    public void onHorizontalSwipe() {
        System.out.println("TextView has been HORIZONTALLY swiped");
    }
}
