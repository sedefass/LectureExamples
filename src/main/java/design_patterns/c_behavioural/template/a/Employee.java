package design_patterns.c_behavioural.template.a;

public abstract class Employee {
    public abstract void work();
    public abstract void takePause();
    public abstract void getPaid();

    public final void goToWork() {
        work();
        takePause();
        work();
        getPaid();
    }
}