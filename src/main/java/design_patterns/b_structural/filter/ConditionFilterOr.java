package design_patterns.b_structural.filter;

import java.util.*;

public class ConditionFilterOr implements Filter {

    private List<Filter> filters = new ArrayList<>();

    public ConditionFilterOr(Filter... filters) {
        this.filters.addAll(Arrays.asList(filters));
    }

    @Override
    public List<Employee> applyFilter(List<Employee> employeeList) {

        Set<Employee> result = new HashSet<>(employeeList);

        for (Filter filter: filters) {
            result.addAll(filter.applyFilter(employeeList));
        }

        return new ArrayList<>(result);
    }
}
