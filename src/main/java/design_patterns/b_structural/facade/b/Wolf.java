package design_patterns.b_structural.facade.b;

import design_patterns.b_structural.facade.a.Animal;

public class Wolf implements Animal {

    @Override
    public void feed() {
        System.out.println("The wolf is being fed!");
    }

}