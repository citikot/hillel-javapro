package homework20.strategy;

public class Triangle extends Figure {

    private double side1, side2, side3;
    public Triangle(double side1, double side2, double side3) {
        super(new TriangleAreaCalculation());
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle triangle)) return false;

        if (Double.compare(triangle.getSide1(), getSide1()) != 0) return false;
        if (Double.compare(triangle.getSide2(), getSide2()) != 0) return false;
        return Double.compare(triangle.getSide3(), getSide3()) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getSide1());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getSide2());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getSide3());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
