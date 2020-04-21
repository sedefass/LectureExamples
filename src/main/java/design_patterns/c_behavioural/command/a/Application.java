package design_patterns.c_behavioural.command.a;

public class Application {
    private String name;

    public Application(String name) {
        this.name = name;
    }

    public void make() {
        System.out.println(name + " app is made for the client.");
    }

    public void sell() {
        System.out.println(name + " app is sold to the client.");
    }
}