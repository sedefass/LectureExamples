package design_patterns.c_behavioural.command;

import design_patterns.c_behavioural.command.a.Application;
import design_patterns.c_behavioural.command.b.MakeApplication;
import design_patterns.c_behavioural.command.b.SellApplication;
import design_patterns.c_behavioural.command.c.Programmer;

public class Main {
    public static void main(String[] args) {
        // command
        Application application = new Application("Accounting");

        //wrapping requests
        MakeApplication makeApplication = new MakeApplication(application);
        SellApplication sellApplication = new SellApplication(application);

        // invoker
        Programmer programmer = new Programmer();
        programmer.takeOrder(makeApplication);
        programmer.takeOrder(sellApplication);
        programmer.takeOrder(makeApplication);

        // invoker processed the wrapped request
        programmer.placeOrders();
    }
}