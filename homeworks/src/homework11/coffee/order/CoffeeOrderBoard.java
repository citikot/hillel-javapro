package homework11.coffee.order;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class CoffeeOrderBoard {
    private Queue<Order> orderBoard;
    private static int counter = 1;

    public CoffeeOrderBoard() {
        orderBoard = new PriorityQueue<>(5, (o1, o2) -> o1.getOrderNumber() - o2.getOrderNumber());
    }

    public void add(String name) {
        Order order = new Order(counter, name);
        orderBoard.add(order);
        counter += 1;
    }

    public void deliver(){
        orderBoard.remove();
    }

    public void deliver(int number) {
        for (Order order : orderBoard) {
            if (order.getOrderNumber() == number){
                orderBoard.remove(order);
                break;
            }
        }
    }

    public void draw() {
        System.out.println("++================");
        System.out.println("   Number |  Name ");


        for (Order elem : orderBoard){
            StringBuffer row = new StringBuffer();
            row.append("       ");
            row.append(elem.getOrderNumber());
            row.append("  |  ");
            row.append(elem.getOrderOwner());
            System.out.println(row);
        }
    }

}
