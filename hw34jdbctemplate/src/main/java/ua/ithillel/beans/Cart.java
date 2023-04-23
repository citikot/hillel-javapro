package ua.ithillel.beans;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.DEFAULT)
public class Cart{

    private final List<Product> cartContent = new ArrayList<>();

    public void addProductById(int id, ProductRepository productRepository) {
        cartContent.add(productRepository.getProductById(id));
    }

    public void deleteProductById(int id, ProductRepository productRepository) {
        cartContent.remove(productRepository.getProductById(id));
    }

    public List<Product> getCartContent() {
        return cartContent;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartContent=" + cartContent +
                '}';
    }
}
