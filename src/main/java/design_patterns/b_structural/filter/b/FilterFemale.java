package design_patterns.b_structural.filter.b;

import design_patterns.b_structural.filter.a.Employee;
import design_patterns.b_structural.filter.a.Filter;

import java.util.ArrayList;
import java.util.List;

public class FilterFemale implements Filter {

    @Override
    public List<Employee> applyFilter(List<Employee> employeeList) {
        List<Employee> femaleEmployees = new ArrayList<>();

        for(Employee employee : employeeList) {
            if(employee.getGender().equalsIgnoreCase("Female")) {
                femaleEmployees.add(employee);
            }
        }

        return femaleEmployees;
    }
}