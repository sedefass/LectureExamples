package design_patterns.b_structural.decorator.c;

import design_patterns.b_structural.decorator.a.Computer;

public abstract class ComputerDecorator implements Computer {

    protected Computer computer;

    public ComputerDecorator(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void assemble() {
        this.computer.assemble();
    }

}