package ua.ithillel.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.ithillel.interfaces.ProductRepoOps;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.ArrayList;

@Repository
public class ProductRepository implements ProductRepoOps {

    @Autowired
    private List<Product> productRepository;

    public ProductRepository(){
         this.productRepository = new ArrayList<>();
    }

    @PostConstruct
    private void init(){
        productRepository.add(new Product(1, "Milk", 42.40));
        productRepository.add(new Product(2, "Sugar", 48.50));
        productRepository.add(new Product(3, "Pasta", 68.20));
        productRepository.add(new Product(4, "Chocolate", 40));
        productRepository.add(new Product(5, "Ketchup", 38.20));
        productRepository.add(new Product(6, "Potato", 12.50));
        productRepository.add(new Product(7, "Tomamto", 120.78));
        productRepository.add(new Product(8, "Burak", 22.20));
        productRepository.add(new Product(9, "Bread", 27.00));
        productRepository.add(new Product(10, "Water", 38.60));
        productRepository.add(new Product(11, "Eggs", 67.20));
        productRepository.add(new Product(12, "Butter", 78.80));
    }

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
