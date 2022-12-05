package homework3.part1;

public class SameName {
    private String name;

    public SameName(String name) {
        setName(name);
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
        if (!(o instanceof SameName sameName)) return false;

        return getName().equals(sameName.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
