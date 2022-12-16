package homework4.part2;

public class Runway implements Obstacle {

    private int runwayLength;

    private String name = "runway";

    public Runway(int length) {
        setRunwayLength(length);
    }

    public int getRunwayLength() {
        return runwayLength;
    }

    public void setRunwayLength(int runwayLength) {
        this.runwayLength = runwayLength;
    }

    public String getName() {
        return name;
    }
}
