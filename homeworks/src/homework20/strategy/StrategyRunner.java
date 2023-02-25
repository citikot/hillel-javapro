package homework20.strategy;

public class StrategyRunner {

    public static void main(String[] args) {
        System.out.println("Strategy Demo");
        Triangle triangle = new Triangle(10.2, 14.3, 13.1);
        System.out.format("%.2f%n", triangle.areaCalculation.getArea(triangle.getSide1(), triangle.getSide2(), triangle.getSide3()));
        triangle = new Triangle(5, 7, 9);
        System.out.format("%.2f%n", triangle.areaCalculation.getArea(triangle.getSide1(), triangle.getSide2(), triangle.getSide3()));
        Rectangle rectangle = new Rectangle(10, 5);
        System.out.format("%.2f%n", rectangle.areaCalculation.getArea(rectangle.getSide1(), rectangle.getSide2()));
        rectangle = new Rectangle(5.5, 8.6);
        System.out.format("%.2f%n",rectangle.areaCalculation.getArea(rectangle.getSide1(), rectangle.getSide2()));
    }
}
