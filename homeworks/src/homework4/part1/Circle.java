package homework4.part1;

public class Circle implements Figure {

    private int radius;

    public Circle(){
        setRadius(DEFAULT_SIDE);
    }

    public Circle(int radius){
        setRadius(replaceNegativeByDefault(radius));
    }

    public double calculateArea() {
        return Math.PI * Math.pow(getRadius(), 2);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle circle)) return false;

        return getRadius() == circle.getRadius();
    }

    @Override
    public int hashCode() {
        return getRadius();
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
