package homework20.factory;

public class Cabinet implements Furniture{

    @Override
    public void produced() {
        System.out.println("Cabinet is produced.");
    }
}
