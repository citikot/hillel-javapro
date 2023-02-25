package homework20.strategy;

public class TriangleAreaCalculation implements AreaCalculation{
    @Override
    public double getArea(double... params) {
        double p = (params[0] + params[1] + params[2]) / 2;
        return Math.sqrt(p * (p - params[0]) * (p - params[1]) * (p - params[2]));
    }
}
