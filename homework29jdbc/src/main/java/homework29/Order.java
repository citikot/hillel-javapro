package homework29;

import java.sql.Date;
import java.util.Objects;

public class Order {

    private static int orderCounter = 10500;

    private int orderNumber;
    private int customerNumber;
    private String status;
    private String comments;

    private Date orderDate;
    private Date requiredDate;
    private Date shippedDate;

    public Order(){};

    public Order(int customerNumber, Date orderDate, Date requiredDate, Date shippedDate, String status, String comments){
        this.orderNumber = orderCounter++;
        this.customerNumber = customerNumber;
        this.status = status;
        this.comments = comments;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
    };

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return customerNumber == order.customerNumber && status.equals(order.status) && Objects.equals(comments, order.comments) && orderDate.equals(order.orderDate) && requiredDate.equals(order.requiredDate) && shippedDate.equals(order.shippedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerNumber, status, comments, orderDate, requiredDate, shippedDate);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", customerNumber=" + customerNumber +
                ", status='" + status + '\'' +
                ", comments='" + comments + '\'' +
                ", orderDate=" + orderDate +
                ", requiredDate=" + requiredDate +
                ", shippedDate=" + shippedDate +
                '}';
    }
}
