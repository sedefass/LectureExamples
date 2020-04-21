package design_patterns.c_behavioural.state;

import design_patterns.c_behavioural.state.a.Context;
import design_patterns.c_behavioural.state.b.ApplicationFinish;
import design_patterns.c_behavioural.state.b.ApplicationStart;

public class Main {
    public static void main(String[] args) {
        Context context = new Context();

        ApplicationStart start = new ApplicationStart();
        start.doAction(context);

        System.out.println(context.getState());

        ApplicationFinish finish = new ApplicationFinish();
        finish.doAction(context);

        System.out.println(context.getState());
    }
}