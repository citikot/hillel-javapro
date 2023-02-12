package homework19;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static homework19.FruitType.*;
import static homework19.Vitamin.*;


public class MainLambdaTemplateStudents {
    public static void main(String[] args) {
        List<Fruit> fruits = fillFruitsList();
        System.out.println("List of fruits:");
        fruits.forEach(System.out::println);

        System.out.println("***");

        /*
        Вивести список (List) всіх фруктів в яких є вітамін С і/або вітамін А
         */
        System.out.println(fruits.stream()
                .filter(fruit -> fruit.getVitamins().contains(A) || fruit.getVitamins().contains(C))
                .toList());

        System.out.println("***");

        /*
        Вивести список без повторів (Set), усіх вітамінів в алфавітному порядку
         */
        System.out.println(fruits.stream()
                .flatMap(fruit -> fruit.getVitamins().stream())
                .collect(Collectors.toSet()).stream()
                .sorted()
                .toList());

        System.out.println("***");

        /*
        Знайти скільки фруктів кожного типу ми маємо
         */
        System.out.println(fruits.stream()
                .collect(Collectors.groupingBy(Fruit::getFruitType,Collectors.counting())));

        System.out.println("***");

        /*
        Знайти три фрукта з найбільшим часом зберігання
         */
        System.out.println(fruits.stream()
                .sorted((f1, f2) -> f2.getDayToLive() - f1.getDayToLive())
                .limit(3)
                .toList());

        System.out.println("***");

        /*
        Вивести мапу з типом фрукта як ключ, з найдешевшими фруктами.
        Тобто якщо дві груші, та в якості value буде дешевша груша
         */
        TreeMap<FruitType, Fruit> fruitTypeMap = fruits.stream()
                .sorted((f1, f2) -> f2.getDayToLive() - f1.getDayToLive())
                .collect(Collectors.toMap(Fruit::getFruitType,
                        Function.identity(),
                        (fr1, fr2) -> fr2,
                        TreeMap::new));
        System.out.println(fruitTypeMap);

        System.out.println("***");

        /*
        Вивести мапу з типом фрукта як ключ, з списком відповідних фруктів.
        Тобто якщо дві груші, та в якості value буде ліст з цих двох груш
         */
        System.out.println(fruits.stream()
                .collect(Collectors.groupingBy(Fruit::getFruitType)));

    }


    private static List<Fruit> fillFruitsList() {
        List<Fruit> fruits = new ArrayList<>();

        Fruit fruit = new Fruit(APPLE, 30, LocalDate.of(2019, 1, 4), 12, null);
        fruit.setVitamins(List.of(B, C));
        fruits.add(fruit);

        fruit = new Fruit(STRAWBERRY, 15, LocalDate.of(2019, 1, 2), 50, null);
        fruit.setVitamins(List.of(A, C));
        fruits.add(fruit);

        fruit = new Fruit(PEAR, 30, LocalDate.of(2019, 1, 4), 40, null);
        fruit.setVitamins(List.of(A, B1, B2, C));
        fruits.add(fruit);

        fruit = new Fruit(ORANGE, 60, LocalDate.of(2019, 1, 3), 30, null);
        fruit.setVitamins(List.of(E, B, A));
        fruits.add(fruit);

        fruit = new Fruit(STRAWBERRY, 25, LocalDate.of(2019, 1, 2), 60, null);
        fruit.setVitamins(List.of(A, C, D));
        fruits.add(fruit);

        fruit = new Fruit(PEAR, 15, LocalDate.of(2019, 1, 4), 40, null);
        fruit.setVitamins(List.of(A, B, B1, B2, P));
        fruits.add(fruit);

        fruit = new Fruit(PEAR, 5, LocalDate.of(2019, 1, 6), 10, null);
        fruit.setVitamins(List.of(B1, B2, P));
        fruits.add(fruit);

        fruit = new Fruit(APPLE, 30, LocalDate.of(2019, 1, 4), 12, null);
        fruit.setVitamins(List.of(B, C));
        fruits.add(fruit);

        return fruits;
    }
}