package design_patterns.c_behavioural.template;

import design_patterns.c_behavioural.template.a.Employee;
import design_patterns.c_behavioural.template.b.Manager;
import design_patterns.c_behavioural.template.b.Programmer;

public class Main {

    public static void main(String[] args) {
        Employee employee = new Programmer();
        employee.goToWork();

        System.out.println();

        employee = new Manager();
        employee.goToWork();
    }

}