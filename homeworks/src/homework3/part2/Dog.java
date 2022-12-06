package homework3.part2;

public class Dog extends Animal {

    public static int dogsCounter;
    private final int DOG_RUN_LIMIT = 500;
    private final int DOG_SWIM_LIMIT = 10;

    public Dog(){
        dogsCounter += 1;
        setName("Бобик");
    }

    public Dog(String name){
        dogsCounter += 1;
        setName(name);
    }

    public int getDogsCounter() {
        return dogsCounter;
    }

    public void run(int distance) {
        if (distance <= DOG_RUN_LIMIT) {
            super.run(distance);
        } else {
            System.out.println(getName() + " сдох.");
        }
    }

    public void swim(int distance){
        if (distance <= DOG_SWIM_LIMIT) {
            System.out.println(getName() + " проплыл " + distance + " м");
        } else {
            System.out.println(getName() + " утонул.");
        }
    }

}
