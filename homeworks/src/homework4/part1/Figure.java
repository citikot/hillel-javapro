package homework4.part1;

public interface Figure {
    public static final int DEFAULT_SIDE = 10;

    public double calculateArea ();

    public default int replaceNegativeByDefault(int side){
        if (side > 0) {
            return side;
        } else {
            return DEFAULT_SIDE;
        }

    }

}
