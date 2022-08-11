package design_patterns.c_behavioural.chain.of.responsibility.a;

public abstract class Employee {

    protected AuthorityLevel authorityLevel;

    protected Employee nextEmployee;

    public void setNextEmployee(Employee employee) {
        this.nextEmployee = employee;
    }

    public void doWork(AuthorityLevel authorityLevel, String message) {
        if (this.authorityLevel.getLevel() <= authorityLevel.getLevel()) {
            write(message);
        }
        if (nextEmployee != null) {
            nextEmployee.doWork(authorityLevel, message);
        }
    }

    abstract protected void write(String message);

    public void chain() {
        System.out.println(authorityLevel + " before feedback chain");

        if (nextEmployee != null) {
            nextEmployee.chain();
        }

        System.out.println(authorityLevel + " after feedback chain");
    }
}
