package design_patterns.c_behavioural.strategy.c;

import design_patterns.c_behavioural.strategy.a.Strategy;

public class BattleContext {
    private Strategy strategy;

    public BattleContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public String executeStrategy(String strategyElement) {
        return strategy.applyStrategy(strategyElement);
    }
}