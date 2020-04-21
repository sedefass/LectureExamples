package design_patterns.c_behavioural.strategy.b;

import design_patterns.c_behavioural.strategy.a.Strategy;

public class Attack implements Strategy {

    @Override
    public String applyStrategy(String strategyElement) {
        return "Attacking with " + strategyElement;
    }
}