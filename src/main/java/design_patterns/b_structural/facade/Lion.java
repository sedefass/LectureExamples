package design_patterns.b_structural.facade;

public class Lion implements Animal {

    @Override
    public void feed() {
        System.out.println("The lion is being fed!");
    }

}
