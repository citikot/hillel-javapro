package homework20.factory;

public class FurnitureFactory {
    public Furniture getFurniture(FurnitureTypes type){
        Furniture toReturn = null;
        switch (type){
            case TABLE -> toReturn = new Table();
            case CABINET -> toReturn = new Cabinet();
            case DRESSER -> toReturn = new Dresser();
            default -> {
                try {
                    throw new IllegalAccessException("Wrong furniture type: " + type);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return toReturn;
    }
}
