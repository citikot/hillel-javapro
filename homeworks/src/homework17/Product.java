package homework17;

import java.time.LocalDate;

public class Product {
    private int id;
    private String type;
    private double price;
    private boolean discount;
    private LocalDate createDate;

    public Product(int id, String type, double price, boolean discount, LocalDate createDate) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;

        if (getId() != product.getId()) return false;
        if (Double.compare(product.getPrice(), getPrice()) != 0) return false;
        if (isDiscount() != product.isDiscount()) return false;
        if (getType() != null ? !getType().equals(product.getType()) : product.getType() != null) return false;
        return getCreateDate() != null ? getCreateDate().equals(product.getCreateDate()) : product.getCreateDate() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getId();
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (isDiscount() ? 1 : 0);
        result = 31 * result + (getCreateDate() != null ? getCreateDate().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", createDate=" + createDate +
                '}';
    }
}
