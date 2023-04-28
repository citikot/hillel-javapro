package ua.ithillel.beans;

import org.springframework.stereotype.Repository;

@Repository
public class Cart {

    private int cartId;
    private int productId;

    public Cart() {
    }

    public Cart(int cartId, int productId) {
        this.cartId = cartId;
        this.productId = productId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", productId=" + productId +
                '}';
    }
}
