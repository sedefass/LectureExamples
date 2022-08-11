package design_patterns.c_behavioural.strategy.c;

import design_patterns.c_behavioural.strategy.a.BattleStrategy;

public class BattleContext {
    private BattleStrategy battleStrategy;

    public BattleContext(BattleStrategy battleStrategy) {
        this.battleStrategy = battleStrategy;
    }

    public BattleStrategy getStrategy() {
        return battleStrategy;
    }

    public void setStrategy(BattleStrategy battleStrategy) {
        this.battleStrategy = battleStrategy;
    }

    public String executeStrategy(String strategyElement) {
        return battleStrategy.applyStrategy(strategyElement);
    }
}