package design_patterns.b_structural.decorator.d;

import design_patterns.b_structural.decorator.a.Computer;
import design_patterns.b_structural.decorator.c.ComputerDecorator;

public class GamingComputer extends ComputerDecorator {

    public GamingComputer(Computer computer) {
        super(computer);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.print(" Adding characteristics of a gaming computer! ");
    }

}