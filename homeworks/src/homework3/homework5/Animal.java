package homework3.homework5;

public class Animal {
    public static int animalsCounter;

    public String name;

    public Animal() {
        animalsCounter += 1;
    }

    public int getAnimalsCounter(){
        return animalsCounter;
    }

    public void run(int distance){
        System.out.println(getName() + " пробежал " + distance + " м");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal animal)) return false;

        return getName().equals(animal.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
