package homework4.part1;

public class Square extends Figure {

    private int length;

    public Square(){
        setLength(DEFAULT_SIDE);
    }
    public Square(int length) {
        if (length > 0) {
            setLength(length);
        } else {
            setLength(DEFAULT_SIDE);
        }
    }

    public double getArea() {
        return getLength() * getLength();
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square square)) return false;

        return getLength() == square.getLength();
    }

    @Override
    public int hashCode() {
        return getLength();
    }

    @Override
    public String toString() {
        return "Square{" +
                "length=" + length +
                '}';
    }
}
