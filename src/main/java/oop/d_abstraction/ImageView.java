package oop.d_abstraction;

public class ImageView implements OnSwipeListener {

    private byte[] picture;
    private double width;
    private double height;

    public ImageView(byte[] picture, double width, double height) {
        this.picture = picture;
        this.width = width;
        this.height = height;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
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
    public void onVerticalSwipe() {
        // logic for changing the brightness
        System.out.println("ImageView has been VERTICALLY swiped");
    }

    @Override
    public void onHorizontalSwipe() {
        // logic for changing the picture with another one
        System.out.println("ImageView has been HORIZONTALLY swiped");
    }
}
