package coffee.order;

public class CoffeeOrderBoardRunner {
    public static void main(String[] args) {
        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();

        orderBoard.add("Alen");
        orderBoard.add("Alex");
        orderBoard.add("Yongy");
        orderBoard.add("Drax");
        orderBoard.add("Miranda");
        orderBoard.add("Ego");
        orderBoard.add("Groot");
        orderBoard.add("Stallone");

        orderBoard.draw();

        orderBoard.deliver();
        orderBoard.deliver();
        orderBoard.deliver();
        orderBoard.deliver();
        orderBoard.deliver();

        orderBoard.draw();

        orderBoard.deliver(7);
        orderBoard.deliver(6);

        orderBoard.draw();
    }
}
