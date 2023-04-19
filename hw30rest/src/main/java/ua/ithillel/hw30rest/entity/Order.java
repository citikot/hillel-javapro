package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private static int counter = 1;

    private int id;
    private LocalDateTime date;
    private double cost;
    private List<Product> productList;

    public Order(int id, LocalDateTime date) {
        this.id = counter++;
        this.date = date;
        this.cost = 0.0;
        this.productList = new ArrayList<Product>();
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public double getCost() {
        return cost;
    }

    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", cost=" + cost +
                ", productList=" + productList +
                '}';
    }
}