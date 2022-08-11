package design_patterns.b_structural.decorator;

import design_patterns.b_structural.decorator.a.Computer;
import design_patterns.b_structural.decorator.b.BasicComputer;
import design_patterns.b_structural.decorator.d.GamingComputer;
import design_patterns.b_structural.decorator.d.WorkComputer;

public class Main {

    public static void main(String[] args) {
        Computer workComputer = new WorkComputer(new BasicComputer());
        workComputer.assemble();

        System.out.println();

        Computer gamingComputer = new GamingComputer(new WorkComputer(new BasicComputer()));
        gamingComputer.assemble();

        System.out.println();

        Computer compicatedComputer = new GamingComputer(new WorkComputer(new WorkComputer(new GamingComputer(new BasicComputer()))));
        compicatedComputer.assemble();
    }

}
