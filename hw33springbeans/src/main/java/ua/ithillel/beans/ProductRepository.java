package ua.ithillel.beans;

import org.springframework.stereotype.Component;
import ua.ithillel.entities.Product;
import ua.ithillel.interfaces.ProductRepoOps;

import java.util.*;
import java.util.ArrayList;

@Component
public class ProductRepository implements ProductRepoOps {

    List<Product> productRepository = new ArrayList<>();

    @Override
    public void addProduct(Product product) {
        productRepository.add(product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.removeIf(product -> product.getId() == id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository;
    }

    @Override
    public Product getProductById(int id) {
        for (Product product : productRepository) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "ProductRepository{" +
                "productRepository=" + productRepository +
                '}';
    }
}
