package homework4.part1;

public class TestCase {
    public static void main(String[] args) {
        Figure[] arr = {
                new Circle(),
                new Square(),
                new Square(16),
                new Triangle(),
                new Triangle(15,20,35),
                new Circle(8)
        };
        double totalSquare = calculateTotalSquare(arr);
        System.out.print("Total square of figures given equals to: ");
        System.out.printf("%.2f%n", totalSquare);
    }

    private static double calculateTotalSquare(Figure[] arr){
        double totalSquare = 0;
        for (Figure figure : arr) {
            totalSquare += figure.getArea();
        }
        return totalSquare;
    }
}
