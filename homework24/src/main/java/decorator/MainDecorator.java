package decorator;

import java.awt.*;

public class MainDecorator {
    public static void main(String[] args) {
        Shape circle = new Circle();

        System.out.println("Circle with normal border");
        circle.draw();

        Shape redBorderCircle = new ShapeBorderColorDecorator(circle, Color.RED);

        System.out.println("\nCircle of red border");
        redBorderCircle.draw();

        Shape yellowRedBorderCircle = new ShapeFillColorDecorator(redBorderCircle, Color.YELLOW);

        System.out.println("\nCircle of red border with yellow filling");
        yellowRedBorderCircle.draw();
        
        Shape greenRedBorderCircle = new ShapeFillColorDecorator(yellowRedBorderCircle, Color.GREEN);

        System.out.println("\nCircle of red border with green filling on yellow before");
        greenRedBorderCircle.draw();

    }
}
