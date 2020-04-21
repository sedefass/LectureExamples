package design_patterns.c_behavioural.observer;

import design_patterns.c_behavioural.observer.a.Programmer;
import design_patterns.c_behavioural.observer.b.CEO;
import design_patterns.c_behavioural.observer.b.Manager;
import design_patterns.c_behavioural.observer.b.TeamLeader;

public class Main {
    public static void main(String[] args) {
        Programmer programmer = new Programmer();

        new CEO(programmer);
        new Manager(programmer);
        new TeamLeader(programmer);

        System.out.println("Programmer successfully did his job!");
        programmer.setState("Successful");

        System.out.println();

        System.out.println("Programmer failed his new assignment.");
        programmer.setState("Failed");
    }
}