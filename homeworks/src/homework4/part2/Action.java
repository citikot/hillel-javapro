package homework4.part2;

public interface Action {

    public default void run(String name){
        System.out.println(name + " is running on Runway.");
    }

    public default void jump(String name){
        System.out.println(name + " is jumping over the Wall.");
    }

}
