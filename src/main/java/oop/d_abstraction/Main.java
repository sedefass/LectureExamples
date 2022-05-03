package oop.d_abstraction;

import java.awt.*;

public class Main {

    // Inspired by android, but this is not what actually happens in android!!!
    public static void main(String[] args) {
        Button button = new Button("blue", "Login", 120, 30);
        button.onClick();

        ImageView imageView = new ImageView(new byte[]{}, 120, 120);
        imageView.onLongClick();
        imageView.onLongClick(5);

        TextView textView = new TextView("OOP is in the ba...", new Font("", 1, 1) , 120, 60);
        textView.onClick();
        textView.onLongClick();
        textView.onLongClick(7);

        OnLongClickListener myCustomImplementation = new OnLongClickListener() {  // Anonymous class implementation of OnLongClickListener interface
            @Override
            public void onLongClick() {
                System.out.println("My custom implementation has been long clicked");
            }

            @Override
            public void onLongClick(int seconds) {
                System.out.println("My custom implementation has been long clicked for " + seconds);
            }
        };

        myCustomImplementation.onLongClick();
        myCustomImplementation.onLongClick(10);
    }

}
