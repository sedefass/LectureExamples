package design_patterns.c_behavioural.chain.of.responsibility.b;

import design_patterns.c_behavioural.chain.of.responsibility.a.Employee;

public class LeadProgrammer extends Employee {

    public LeadProgrammer(int authorityLevel) {
        this.authorityLevel = authorityLevel;
    }

    @Override
    protected void write(String message) {
        System.out.println("Lead programmer is working on project: " + message);
    }
}