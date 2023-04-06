package template;

public class StoreOrder extends OrderProcessTemplate {

    @Override
    public void selectGoods() {
        System.out.println("Customer chooses the item from shelf.");
    }

    @Override
    public void payment() {
        System.out.println("Pays at counter through cash/POS");
    }

    @Override
    public void delivery() {
        System.out.println("Item delivered to in delivery counter.");
    }

}