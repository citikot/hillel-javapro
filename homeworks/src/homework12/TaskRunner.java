package homework12;

public class TaskRunner {
    public static void main(String[] args) {
        Integer[] arr1 = {1,2,3,4,5};
        String[] arr2 = {"a","b","c","d","e"};
        Double[] arr3 = {1.2,3.4,5.6,7.8,9.1};
        ArrayToList modifier = new ArrayToList();
        System.out.println(modifier.toList(arr1));
        System.out.println(modifier.toList(arr2));
        System.out.println(modifier.toList(arr3));

        Box<Apple> box1 = new Box<>(new Apple(1.0F));
        Box<Apple> box2 = new Box<>(new Apple(1.0F));
        Box<Apple> box3 = new Box<>(new Apple(1.0F));
        Box<Orange> box4 = new Box<>(new Orange(1.5F));
        Box<Orange> box5 = new Box<>(new Orange(1.5F));
        Box<Orange> box6 = new Box<>(new Orange(1.5F));
        box1.addOne();
        System.out.println(box1.getAmount());
        box1.addMany(14);
        System.out.println(box1.getAmount());
        System.out.println(box1.getWeight());
        box4.addMany(10);
        System.out.println(box4.getWeight());
        System.out.println(box1.compare(box4));
        System.out.println(box1.compare(box3));
        System.out.println(box1.compare(box6));
        System.out.println(box1.merge(box5));
        box2.addMany(5);
        System.out.println(box1.merge(box2));
        System.out.println(box1.getAmount());
        System.out.println(box2.getAmount());
    }
}
