package design_patterns.c_behavioural.strategy.b;

import design_patterns.c_behavioural.strategy.a.Strategy;

public class Deffend implements Strategy {

    @Override
    public String applyStrategy(String strategyElement) {
        return "Defending with " + strategyElement;
    }
}