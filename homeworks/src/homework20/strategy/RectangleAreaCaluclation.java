package homework20.strategy;

public class RectangleAreaCaluclation implements AreaCalculation{
    @Override
    public double getArea(double... params) {
        return params[0] * params[1];
    }
}
