package homework4.part2;

public class Participant implements Action {

    protected int runLimit;

    protected int jumpLimit;

    protected String name;

    public int getRunLimit() {
        return runLimit;
    }

    public void setRunLimit(int runLimit) {
        this.runLimit = runLimit;
    }

    public int getJumpLimit() {
        return jumpLimit;
    }

    public void setJumpLimit(int jumpLimit) {
        this.jumpLimit = jumpLimit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Participant that)) return false;

        if (getRunLimit() != that.getRunLimit()) return false;
        if (getJumpLimit() != that.getJumpLimit()) return false;
        return getName() != null ? getName().equals(that.getName()) : that.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getRunLimit();
        result = 31 * result + getJumpLimit();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }
}
