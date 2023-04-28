package ua.ithillel.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.ithillel.mappers.ProductRowMapper;

import java.util.*;

@Repository
public class ProductDao {

    public JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Product> getProductList(){
        return jdbcTemplate.query("SELECT * FROM products", new ProductRowMapper());
    }

    public List<Product> getProductById(int productId){
        return jdbcTemplate.query("SELECT * FROM products WHERE id = ?", new Object[] {productId}, new ProductRowMapper());
    }

    public void addProduct(Product product){
        jdbcTemplate.update("INSERT INTO products VALUES (?,?,?)", product.getId(), product.getName(), product.getPrice());
    }

    public void deleteProductById(int productId){
        jdbcTemplate.update("DELETE FROM products WHERE id = ?", productId);
    }

}
