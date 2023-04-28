package ua.ithillel.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ua.ithillel.mappers.CartItemRowMapper;
import ua.ithillel.mappers.ProductRowMapper;

import java.util.ArrayList;
import java.util.List;

@Component
public class CartDao {

    public JdbcTemplate jdbcTemplate;

    @Autowired
    public CartDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createCart(int cartId){
        jdbcTemplate.update("INSERT INTO carts(cartId) VALUES (?)", cartId);
    }

    public void addProductToCart(int cartId, int productId){
        jdbcTemplate.update("INSERT INTO carts VALUES (?, ?)", cartId, productId);
    }


    public List<List<Product>> getProductListForCartId(int cartId){
        List<List<Product>> products = new ArrayList<>();

        List<Cart> productIdListInCart = jdbcTemplate.query("SELECT * FROM carts WHERE cartId = ?",
                new Object[] {cartId},
                new CartItemRowMapper());
        for (Cart cartItem : productIdListInCart) {
            products.add(jdbcTemplate.query("SELECT * FROM products WHERE id = ?",
                    new Object[] {cartItem.getProductId()},
                    new ProductRowMapper()));
        }
        return products;
    }

    public void deleteProductByIdFromCart(int cartId, int productId){
        jdbcTemplate.update("DELETE FROM carts WHERE cartId = ? AND productId = ?", cartId, productId);
    }
}
