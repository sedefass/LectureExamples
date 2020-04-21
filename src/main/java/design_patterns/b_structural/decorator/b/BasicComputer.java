package design_patterns.b_structural.decorator.b;

import design_patterns.b_structural.decorator.a.Computer;

public class BasicComputer implements Computer {

    @Override
    public void assemble() {
        System.out.print("Assembling a basic computer.");
    }

}