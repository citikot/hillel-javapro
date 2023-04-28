package ua.ithillel.mappers;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ua.ithillel.beans.Cart;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CartItemRowMapper implements RowMapper<Cart> {
        public Cart mapRow(ResultSet rs, int i) throws SQLException {
            return new Cart(
                    rs.getInt("cartId"),
                    rs.getInt("productId")
            );
        }

}
