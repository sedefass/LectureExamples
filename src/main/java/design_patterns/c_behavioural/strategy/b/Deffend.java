package design_patterns.c_behavioural.strategy.b;

import design_patterns.c_behavioural.strategy.a.BattleStrategy;

public class Deffend implements BattleStrategy {

    @Override
    public String applyStrategy(String strategyElement) {
        return "Defending with " + strategyElement;
    }
}