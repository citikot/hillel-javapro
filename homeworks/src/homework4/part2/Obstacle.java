package homework4.part2;

public interface Obstacle {

    public default boolean overcome(int limit, int actual) {
        return actual >= limit;
    }

}

