package homework3.homework5;

public class TestCase {
    public static void main(String[] args) {
        Animal an1 = new Animal();
        System.out.println("Животных: " + an1.getAnimalsCounter());

        Dog dog1 = new Dog();
        System.out.println("Животных: " + dog1.getAnimalsCounter());
        System.out.println("Cобак: " + dog1.getDogsCounter() );
        dog1.run(120);
        dog1.swim(9);

        Dog dog2 = new Dog("Вулкан");
        System.out.println("Животных: " + dog2.getAnimalsCounter());
        System.out.println("Cобак: " + dog2.getDogsCounter());
        dog2.run(520);
        dog2.swim(13);

        Cat cat1 = new Cat();
        System.out.println("Животных: " + cat1.getAnimalsCounter());
        System.out.println("Котов: " + cat1.getCatsCounter() );
        cat1.run(120);

        Cat cat2 = new Cat("Васька");
        System.out.println("Животных: " + dog2.getAnimalsCounter()); // checking static
        System.out.println("Котов: " + cat2.getCatsCounter() );
        cat2.run(220);
    }
}
