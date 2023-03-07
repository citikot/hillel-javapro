package coffee.order;

public class CoffeeOrderBoardRunner {
    public static void main(String[] args) {
        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();

        orderBoard.deliver(111);
        orderBoard.deliver();

        orderBoard.add("Alen");
        orderBoard.add("Alex");
        orderBoard.add("Yongy");
        orderBoard.add("Drax");
        orderBoard.add("Ego");
        orderBoard.add("Groot");
        orderBoard.add("Stallone");
        orderBoard.deliver();
        orderBoard.deliver();
        orderBoard.deliver();
        orderBoard.deliver();
        orderBoard.deliver();
        orderBoard.deliver(3);
        orderBoard.deliver(7);
        orderBoard.deliver();
        orderBoard.deliver(222);
    }
}
