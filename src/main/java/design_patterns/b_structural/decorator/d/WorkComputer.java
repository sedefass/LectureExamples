package design_patterns.b_structural.decorator.d;

import design_patterns.b_structural.decorator.a.Computer;
import design_patterns.b_structural.decorator.c.ComputerDecorator;

public class WorkComputer extends ComputerDecorator {

    public WorkComputer(Computer computer) {
        super(computer);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.print(" Adding characteristics of a work computer! ");
    }

}
