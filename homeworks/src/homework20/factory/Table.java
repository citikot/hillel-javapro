package homework20.factory;

public class Table implements Furniture{
    @Override
    public void produced() {
        System.out.println("Table is produced.");
    }
}
