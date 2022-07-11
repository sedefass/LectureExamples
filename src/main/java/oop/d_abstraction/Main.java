package oop.d_abstraction;

import java.awt.*;

public class Main {

    // Inspired by android, but this is not what actually happens in android!!!
    public static void main(String[] args) {
        Button button = new Button("blue", "Login", 120, 30);
        button.onClick();
        System.out.println();

        ImageView imageView = new ImageView(new byte[]{}, 120, 120);
        imageView.onVerticalSwipe();
        imageView.onHorizontalSwipe();
        System.out.println();

        TextView textView = new TextView("OOP is in the ba...", new Font("", 1, 1) , 120, 60);
        textView.onClick();
        textView.onVerticalSwipe();
        textView.onHorizontalSwipe();
        System.out.println();

        OnSwipeListener myCustomImplementation = new OnSwipeListener() {  // Anonymous class implementation of OnSwipeListener interface

            private String hehe = "hehe it works ;) ";

            @Override
            public void onVerticalSwipe() {
                System.out.println(hehe +  "My custom implementation has been VERTICALLY swiped");
            }

            @Override
            public void onHorizontalSwipe() {
                System.out.println("My custom implementation has been HORIZONTALLY swiped");
            }
        };

        myCustomImplementation.onVerticalSwipe();
        myCustomImplementation.onHorizontalSwipe();
    }

}
