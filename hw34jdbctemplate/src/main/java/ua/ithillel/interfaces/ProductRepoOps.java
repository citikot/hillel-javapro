package ua.ithillel.interfaces;

import ua.ithillel.beans.Product;

import java.util.List;

public interface ProductRepoOps {
    void addProduct(Product product);

    void deleteProduct(int id);

    List<Product> getAllProducts();
    Product getProductById(int id);


}
