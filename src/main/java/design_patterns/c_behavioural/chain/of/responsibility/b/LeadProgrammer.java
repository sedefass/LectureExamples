package design_patterns.c_behavioural.chain.of.responsibility.b;

import design_patterns.c_behavioural.chain.of.responsibility.a.AuthorityLevel;
import design_patterns.c_behavioural.chain.of.responsibility.a.Employee;

public class LeadProgrammer extends Employee {

    public LeadProgrammer(AuthorityLevel authorityLevel) {
        this.authorityLevel = authorityLevel;
    }

    @Override
    protected void write(String message) {
        System.out.println("Lead programmer is working on project: " + message);
    }

    @Override
    public void chain() {
        System.out.println(authorityLevel + " before feedback chain Override");

        if (nextEmployee != null) {
            nextEmployee.chain();
        }

        System.out.println(authorityLevel + " after feedback chain Override");
    }
}