package design_patterns.b_structural.facade;

import design_patterns.b_structural.facade.c.ZooKeeper;

public class Main {
    public static void main(String[] args) {
        ZooKeeper zookeeper = new ZooKeeper();

        zookeeper.feedLion();
        zookeeper.feedWolf();
        zookeeper.feedBear();
    }
}