package homework11.coffee.order;

import java.util.Comparator;

public class Order {
    private int orderNumber;
    private String orderOwner;

    public Order(int orderNumber, String orderOwner) {
        this.orderNumber = orderNumber;
        this.orderOwner = orderOwner;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderOwner() {
        return orderOwner;
    }

    public void setOrderOwner(String orderOwner) {
        this.orderOwner = orderOwner;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", orderOwner='" + orderOwner + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;

        if (getOrderNumber() != order.getOrderNumber()) return false;
        return getOrderOwner().equals(order.getOrderOwner());
    }

    @Override
    public int hashCode() {
        int result = getOrderNumber();
        result = 31 * result + getOrderOwner().hashCode();
        return result;
    }

}
