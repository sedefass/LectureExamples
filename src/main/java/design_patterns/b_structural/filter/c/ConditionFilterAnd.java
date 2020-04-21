package design_patterns.b_structural.filter.c;

import design_patterns.b_structural.filter.a.Employee;
import design_patterns.b_structural.filter.a.Filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConditionFilterAnd implements Filter {

    private List<Filter> filters = new ArrayList<>();

    public ConditionFilterAnd(Filter... filters) {
        this.filters.addAll(Arrays.asList(filters));
    }

    @Override
    public List<Employee> applyFilter(List<Employee> employeeList) {
        for (Filter filter: filters) {
            employeeList = filter.applyFilter(employeeList);
        }

        return employeeList;
    }
}