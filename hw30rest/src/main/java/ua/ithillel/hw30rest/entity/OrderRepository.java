package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderRepository implements OrderOps {

    private List<Order> orderRepository;

    public OrderRepository() {
        this.orderRepository = new ArrayList<Order>();
    }

    @Override
    public Order getOrder(int id) {
        for(Order order : orderRepository) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository;
    }

    @Override
    public void addOrder(Order order) {
        orderRepository.add(order);
    }

    @Override
    public String toString() {
        return "OrderRepository{" +
                "orderRepository=" + orderRepository +
                '}';
    }
}
