package design_patterns.b_structural.filter;

import java.util.ArrayList;
import java.util.List;

public class FilterMale implements Filter {

    @Override
    public List<Employee> applyFilter(List<Employee> employeeList) {
        List<Employee> maleEmployees = new ArrayList<>();

        for(Employee employee : employeeList) {
            if(employee.getGender().equalsIgnoreCase("Male")) {
                maleEmployees.add(employee);
            }
        }

        return maleEmployees;
    }
}