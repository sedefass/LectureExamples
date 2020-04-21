package design_patterns.c_behavioural.command.b;

import design_patterns.c_behavioural.command.a.Application;
import design_patterns.c_behavioural.command.a.Order;

public class MakeApplication implements Order {
    private Application application;

    public MakeApplication(Application application) {
        this.application = application;
    }

    @Override
    public void placeOrder() {
        application.make();
    }
}