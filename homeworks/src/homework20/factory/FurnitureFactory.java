package homework20.factory;

public class FurnitureFactory {
    public Furniture getFurniture(FurnitureTypes type) throws IllegalAccessException {
        Furniture result = null;
        switch (type){
            case TABLE -> result = new Table();
            case CABINET -> result = new Cabinet();
            case DRESSER -> result = new Dresser();
            default -> throw new IllegalAccessException("Wrong furniture type: " + type);
            }
        return result;
    }
}
