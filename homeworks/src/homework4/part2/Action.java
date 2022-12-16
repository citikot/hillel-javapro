package homework4.part2;

public interface Action {

    public default void run(String name){
        System.out.println(name + " бежит по беговой дорожке.");
    }

    public default void jump(String name){
        System.out.println(name + " прыгает через стену.");
    }

}
