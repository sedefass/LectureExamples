package design_patterns.c_behavioural.strategy.b;

import design_patterns.c_behavioural.strategy.a.BattleStrategy;

public class Retreat implements BattleStrategy {

    @Override
    public String applyStrategy(String strategyElement) {
        return "Retreating through " + strategyElement;
    }
}