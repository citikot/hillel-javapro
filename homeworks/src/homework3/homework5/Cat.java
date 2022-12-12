package homework3.homework5;

public class Cat extends Animal{

    public static int catsCounter;
    private final int CAT_RUN_LIMIT = 200;

    public Cat(){
        catsCounter += 1;
        setName("Барсик");
    }

    public Cat(String name){
        catsCounter += 1;
        setName(name);
    }

    public int getCatsCounter() {
        return catsCounter;
    }

    public void run(int distance) {
        if (distance <= CAT_RUN_LIMIT) {
            super.run(distance);
        } else {
            System.out.println(getName() + " сдох.");
        }
    }

}
