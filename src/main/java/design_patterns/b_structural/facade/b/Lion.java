package design_patterns.b_structural.facade.b;

import design_patterns.b_structural.facade.a.Animal;

public class Lion implements Animal {

    @Override
    public void feed() {
        System.out.println("The lion is being fed!");
    }

}
