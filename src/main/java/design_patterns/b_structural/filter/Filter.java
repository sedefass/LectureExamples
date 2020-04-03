package design_patterns.b_structural.filter;

import java.util.List;

public interface Filter {
    public List<Employee> applyFilter(List<Employee> employeeList);
}
