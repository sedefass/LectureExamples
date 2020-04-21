package design_patterns.b_structural.filter.a;

import java.util.List;

public interface Filter {
    List<Employee> applyFilter(List<Employee> employeeList);
}
