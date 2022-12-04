package homework3.part2;

public class Animal {
    public static int animalsCounter;

    public Animal() {
        animalsCounter += 1;
    }

    public int getAnimalsCounter(){
        return animalsCounter;
    }

    public void run(String name, int distance){
        System.out.println(name + " пробежал " + distance + " м");
    }

}
