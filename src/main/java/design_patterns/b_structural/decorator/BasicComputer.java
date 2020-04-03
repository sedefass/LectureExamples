package design_patterns.b_structural.decorator;

public class BasicComputer implements Computer {

    @Override
    public void assemble() {
        System.out.print("Assembling a basic computer.");
    }

}