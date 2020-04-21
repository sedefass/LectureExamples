package design_patterns.c_behavioural.chain.of.responsibility.b;

import design_patterns.c_behavioural.chain.of.responsibility.a.Employee;

public class Programmer extends Employee {

    public Programmer(int authorityLevel) {
        this.authorityLevel = authorityLevel;
    }

    @Override
    protected void write(String message) {
        System.out.println("Programmer is working on project: " + message);
    }
}