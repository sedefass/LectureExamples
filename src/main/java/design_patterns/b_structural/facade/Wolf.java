package design_patterns.b_structural.facade;

public class Wolf implements Animal {

    @Override
    public void feed() {
        System.out.println("The wolf is being fed!");
    }

}