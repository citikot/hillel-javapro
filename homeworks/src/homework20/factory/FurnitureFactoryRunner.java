package homework20.factory;

public class FurnitureFactoryRunner {
    public static void main(String[] args) throws IllegalAccessException {
        System.out.println("Factory Demo");
        FurnitureFactory factory = new FurnitureFactory();

        Furniture cabinet = factory.getFurniture(FurnitureTypes.CABINET);
        cabinet.produced();
        Furniture dresser = factory.getFurniture(FurnitureTypes.DRESSER);
        dresser.produced();
        Furniture table = factory.getFurniture(FurnitureTypes.TABLE);
        table.produced();
    }
}
