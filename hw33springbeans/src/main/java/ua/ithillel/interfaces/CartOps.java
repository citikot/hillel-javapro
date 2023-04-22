package ua.ithillel.interfaces;

import ua.ithillel.beans.ProductRepository;
import ua.ithillel.entities.Product;

import java.util.List;

public interface CartOps {
    void addProductById(int id, ProductRepository productRepository);

    void deleteProductById(int id, ProductRepository productRepository);

    List<Product> getCartContent();

}
