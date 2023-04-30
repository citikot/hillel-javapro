package hw30rest;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private static List<Order> orderList = new ArrayList<>();

    static {
        Product product1 = new Product(1, "Bread", 27.0);
        Product product2 = new Product(2, "Butter", 67.0);
        Product product3 = new Product(3, "Milk", 44.0);
        Product product4 = new Product(4, "Eggs", 65.0);
        Product product5 = new Product(5, "Popato", 13.5);
        Product product6 = new Product(6, "Apple", 37.0);
        Product product7 = new Product(7, "Banana", 6980);
        Product product8 = new Product(8, "Pasta", 47.0);
        Product product9 = new Product(9, "Sugar", 39.0);
        Product product10 = new Product(10, "Cheese", 127.0);
        Product product11 = new Product(11, "Chicken", 119.0);
        Product product12 = new Product(12, "Meat", 227.0);

        Order order1 = new Order(1, "2022-12-04");
        Order order2 = new Order(2, "2022-12-06");
        Order order3 = new Order(1, "2022-12-09");

        order1.setProducts(List.of(product1, product2, product5, product11));
        order2.setProducts(List.of(product3, product4, product12, product7));
        order3.setProducts(List.of(product6, product8, product9, product10));

        addOrder(order1);
        addOrder(order2);
        addOrder(order3);
    }

    public Order getOrderById(int id){
        return orderList.stream().filter(order -> order.getId() == id).findAny().get();
    }

    public List<Order> getAllOrders(){
        return orderList;
    }

    public static void addOrder(Order order){
        orderList.add(order);
    }


}
