package homework4.part1;

public class Triangle extends Figure {
    private int side1;
    private int side2;
    private int side3;

    public Triangle(){
        setSide1(DEFAULT_SIDE);
        setSide2(DEFAULT_SIDE);
        setSide3(DEFAULT_SIDE);
    }
    public Triangle(int side1, int side2, int side3) {
        if (side1 > 0) {
            setSide1(side1);
        } else {
            setSide1(DEFAULT_SIDE);
        }
        if (side2 > 0) {
            setSide2(side2);
        } else {
            setSide2(DEFAULT_SIDE);
        }
        if (side3 > 0) {
            setSide3(side3);
        } else {
            setSide3(DEFAULT_SIDE);
        }
    }

    public int getSide1() {
        return side1;
    }

    public void setSide1(int side1) {
        this.side1 = side1;
    }

    public int getSide2() {
        return side2;
    }

    public void setSide2(int side2) {
        this.side2 = side2;
    }

    public int getSide3() {
        return side3;
    }

    public void setSide3(int side3) {
        this.side3 = side3;
    }

    public double getArea() {
        // Gerone formula
        double halfPerimeter = (double) (getSide1() + getSide2() + getSide3()) / 2;
        double diff1 = halfPerimeter - getSide1();
        double diff2 = halfPerimeter - getSide2();
        double diff3 = halfPerimeter - getSide3();
        return Math.sqrt(halfPerimeter * diff1 * diff2 * diff3);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle triangle)) return false;

        if (getSide1() != triangle.getSide1()) return false;
        if (getSide2() != triangle.getSide2()) return false;
        return getSide3() == triangle.getSide3();
    }

    @Override
    public int hashCode() {
        int result = getSide1();
        result = 31 * result + getSide2();
        result = 31 * result + getSide3();
        return result;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                '}';
    }
}
