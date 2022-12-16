package homework4.part2;

public class Wall implements Obstacle{

    private int wallHeight;

    private int distance;

    private String name = "wall";

    public Wall(int height, int distance){
        setWallHeight(height);
        setDistance(distance);
    }

    public int getWallHeight() {
        return wallHeight;
    }

    public void setWallHeight(int wallHeight) {
        this.wallHeight = wallHeight;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
