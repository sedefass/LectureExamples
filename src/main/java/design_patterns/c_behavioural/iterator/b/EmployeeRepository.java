package design_patterns.c_behavioural.iterator.b;

import design_patterns.c_behavioural.iterator.a.Iterator;
import design_patterns.c_behavioural.iterator.a.Sector;

public class EmployeeRepository<T> implements Sector {
    private T[] employees;

    public T[] getEmployees() {
        return employees;
    }

    public void setEmployees(T[] employees) {
        this.employees = employees;
    }

    @Override
    public Iterator getIterator() {
        return new EmployeeIterator();
    }

    private class EmployeeIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            if(index < employees.length) {
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            if(this.hasNext()) {
                return employees[index++];
            }
            return null;
        }
    }
}