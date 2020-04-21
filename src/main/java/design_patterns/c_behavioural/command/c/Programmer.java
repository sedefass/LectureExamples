package design_patterns.c_behavioural.command.c;

import design_patterns.c_behavioural.command.a.Order;

import java.util.ArrayList;
import java.util.List;

public class Programmer {
    private List<Order> orderList = new ArrayList<>();

    public void takeOrder(Order order) {
        orderList.add(order);
    }

    public void placeOrders() {
        for(Order order : orderList) {
            order.placeOrder();
        }
        orderList.clear();
    }
}