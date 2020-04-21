package design_patterns.c_behavioural.chain.of.responsibility.b;

import design_patterns.c_behavioural.chain.of.responsibility.a.Employee;

public class Manager extends Employee {

    public Manager(int authorityLevel) {
        this.authorityLevel = authorityLevel;
    }

    @Override
    protected void write(String message) {
        System.out.println("Manager is working on project: " + message);
    }
}