package entity;

import java.util.List;
import java.util.Optional;

public interface OrderOps {
    public Order getOrder(int id);

    public List<Order> getAllOrders();

    public void addOrder(Order order);

}
