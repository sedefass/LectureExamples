package design_patterns.c_behavioural.chain.of.responsibility;

import design_patterns.c_behavioural.chain.of.responsibility.a.AuthorityLevel;
import design_patterns.c_behavioural.chain.of.responsibility.a.Employee;
import design_patterns.c_behavioural.chain.of.responsibility.b.LeadProgrammer;
import design_patterns.c_behavioural.chain.of.responsibility.b.Manager;
import design_patterns.c_behavioural.chain.of.responsibility.b.Programmer;

public class Main {

    public static void main(String[] args) {
        Employee programmer = new Programmer(AuthorityLevel.PROGRAMMER);
        Employee leadProgrammer = new LeadProgrammer(AuthorityLevel.LEAD_PROGRAMMER);
        Employee manager = new Manager(AuthorityLevel.MANAGER);

        programmer.setNextEmployee(leadProgrammer);
        leadProgrammer.setNextEmployee(manager);

        programmer.doWork(AuthorityLevel.PROGRAMMER, "This is basic programming work.");
        System.out.println();
        programmer.doWork(AuthorityLevel.LEAD_PROGRAMMER, "This is marginally more sophisticated programming work.");
        System.out.println();
        programmer.doWork(AuthorityLevel.MANAGER, "This is the work for a manager.");

        System.out.println();
        programmer.chain();
    }
}