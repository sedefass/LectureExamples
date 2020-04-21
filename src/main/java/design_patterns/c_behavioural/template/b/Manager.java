package design_patterns.c_behavioural.template.b;

import design_patterns.c_behavioural.template.a.Employee;

public class Manager extends Employee {

    @Override
    public void work() {
        System.out.println("Managing other employees.");
    }

    @Override
    public void takePause() {
        System.out.println("Taking a small break from managing employees.");
    }

    @Override
    public void getPaid() {
        System.out.println("Getting paid for overseeing the development of the project.");
    }
}