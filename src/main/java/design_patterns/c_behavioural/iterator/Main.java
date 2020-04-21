package design_patterns.c_behavioural.iterator;

import design_patterns.c_behavioural.iterator.a.Iterator;
import design_patterns.c_behavioural.iterator.b.EmployeeRepository;

public class Main {

    public static void main(String[] args) {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        String[] employees = {"David", "Scott", "Rhett", "Andrew", "Jessica"};
        employeeRepository.setEmployees(employees);

        Iterator iterator = employeeRepository.getIterator();
        while (iterator.hasNext()) {
            String employee = (String)iterator.next();
            System.out.println("Employee: " + employee);
        }
    }

}