package design_patterns.b_structural.decorator;

public class Main {

    public static void main(String[] args) {
        Computer gamingComputer = new GamingComputer(new BasicComputer());
        gamingComputer.assemble();
        System.out.println();

        Computer workComputer = new WorkComputer(new GamingComputer(new BasicComputer()));
        workComputer.assemble();
    }

}
