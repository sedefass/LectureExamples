package design_patterns.c_behavioural.strategy;

import design_patterns.c_behavioural.strategy.b.Attack;
import design_patterns.c_behavioural.strategy.b.Deffend;
import design_patterns.c_behavioural.strategy.b.Retreat;
import design_patterns.c_behavioural.strategy.c.BattleContext;

public class Main {
    public static void main(String[] args) {
        BattleContext battleContext = new BattleContext(new Attack());
        System.out.println(battleContext.executeStrategy("punch"));

        battleContext.setStrategy(new Deffend());
        System.out.println(battleContext.executeStrategy("shield"));

        battleContext.setStrategy(new Attack());
        System.out.println(battleContext.executeStrategy("sword"));

        battleContext.setStrategy(new Retreat());
        System.out.println(battleContext.executeStrategy("escape tunnel"));

        //  COMBINATION WITH FACTORY EXAMPLE
        //  BattleStrategyFactory factory = new BattleStrategyFactory();
        //  BattleStrategy strategy = factory.getBattleStrategy(...);
        //  battleContext.setStrategy(strategy);
        //  battleContext.executeStrategy();

        //  LIST EXAMPLE
        //  List<BattleStrategy> battleStrategies;
        //  iterate and applyStrategy
    }
}