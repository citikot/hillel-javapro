package homework3.part2;

public class Cat extends Animal{

    public static int catsCounter;
    private String name;
    private final int CAT_RUN_LIMIT = 200;

    public Cat(){
        catsCounter += 1;
        setName("Барсик");
    }

    public Cat(String name){
        catsCounter += 1;
        setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCatsCounter() {
        return catsCounter;
    }

    public void run(int distance) {
        if (distance <= CAT_RUN_LIMIT) {
            super.run(getName(), distance);
        } else {
            System.out.println(getName() + " сдох.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat cat)) return false;

        return getName().equals(cat.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
