package oop.d_abstraction;

public class ImageView implements OnLongClickListener {

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
    public void onLongClick() {
        System.out.println("ImageView has been LONG clicked");
    }

    @Override
    public void onLongClick(int seconds) {
        System.out.println("ImageView has been LONG clicked for a time of " + seconds);
    }
}
