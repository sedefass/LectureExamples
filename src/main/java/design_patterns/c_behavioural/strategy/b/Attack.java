package design_patterns.c_behavioural.strategy.b;

import design_patterns.c_behavioural.strategy.a.BattleStrategy;

public class Attack implements BattleStrategy {

    @Override
    public String applyStrategy(String strategyElement) {
        return "Attacking with " + strategyElement;
    }
}