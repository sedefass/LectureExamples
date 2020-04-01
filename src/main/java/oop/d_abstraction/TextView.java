package oop.d_abstraction;

import java.awt.*;

public class TextView implements OnClickListener, OnLongClickListener {

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
        System.out.println("TextView has been JUST clicked");
    }

    @Override
    public void onLongClick() {
        System.out.println("TextView has been LONG clicked");
    }

    @Override
    public void onLongClick(int seconds) {
        System.out.println("TextView has been LONG clicked for a time of " + seconds);
    }
}
