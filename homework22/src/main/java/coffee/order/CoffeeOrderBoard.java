package coffee.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

public class CoffeeOrderBoard {
    private Queue<Order> orderBoard;
    private int counter = 1;

    private static final Logger log = LoggerFactory.getLogger(CoffeeOrderBoard.class);

    public CoffeeOrderBoard() {
        orderBoard = new PriorityQueue<>(5, (o1, o2) -> o1.getOrderNumber() - o2.getOrderNumber());
    }

    public void add(String name) {
        Order order = new Order(counter, name);
        orderBoard.add(order);
        log.info("Order number {} added to the queue for {}. ", counter, name);
        counter += 1;
    }

    public void deliver() {
        Order last;
        try {
            last = orderBoard.remove();
        } catch (NoSuchElementException e) {
            log.error("The queue is empty {}", (Object) e.getStackTrace());
            return;
        }
        log.info("Order number {} delivered to {} and removed from queue. ", last.getOrderNumber(), last.getOrderOwner());
    }

    public void deliver(int number) {
        for (Order order : orderBoard) {
            if (order.getOrderNumber() == number) {
                orderBoard.remove(order);
                log.info("Order number {} delivered to {} and removed from queue. ", order.getOrderNumber(), order.getOrderOwner());
                return;
            }
        }
        log.error("The order {} is out of range or the queue is empty. {}", number, new NoSuchElementException().getStackTrace());
    }

    public void draw() {
        System.out.println("++================");
        System.out.println("   Number |  Name ");


        for (Order elem : orderBoard) {
            StringBuffer row = new StringBuffer();
            row.append("       ");
            row.append(elem.getOrderNumber());
            row.append("  |  ");
            row.append(elem.getOrderOwner());
            System.out.println(row);
        }
    }

}
