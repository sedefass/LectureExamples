package design_patterns.c_behavioural.command.b;

import design_patterns.c_behavioural.command.a.Application;
import design_patterns.c_behavioural.command.a.Order;

public class SellApplication implements Order {
    private Application application;

    public SellApplication(Application application) {
        this.application = application;
    }

    @Override
    public void placeOrder() {
        application.sell();
    }
}