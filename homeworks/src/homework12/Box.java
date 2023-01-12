package homework12;

public class Box<T extends Fruit> {
    private int amount;
    private T kind;

    public Box(T kind){
        this.kind = kind;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void addOne() {
        setAmount(getAmount() + 1);
    }

    public void addMany(int amount) {
        setAmount(getAmount() + amount);
    }

    public float getWeight() {
        return getAmount() * kind.getFruitWeight();
    }

    public boolean compare(Box box){
        if ((kind.getClass().toString().equals(box.kind.getClass().toString())) || (getWeight() != box.getWeight())) {
            return false;
        }
        return true;
    }

    public boolean merge(Box box){
        if ((kind.getClass().toString().equals(box.kind.getClass().toString()))) {
            this.addMany(box.getAmount());
            box.setAmount(0);
            return true;
        }
        return false;
    }
}
