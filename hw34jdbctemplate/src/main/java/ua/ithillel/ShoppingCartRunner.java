package ua.ithillel;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.ithillel.beans.CartDao;
import ua.ithillel.beans.Product;
import ua.ithillel.beans.ProductDao;
import ua.ithillel.config.AppConfig;


public class ShoppingCartRunner {
    public static void main(String[] args) {

        ConfigurableApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductDao productDao = appContext.getBean(ProductDao.class);
        CartDao cartDao = appContext.getBean(CartDao.class);

        System.out.println(productDao.getProductList());
        System.out.println(productDao.getProductById(3));

        Product product1 = new Product(20, "Cocoa", 200.45);
        productDao.addProduct(product1);
        System.out.println(productDao.getProductById(20));
        productDao.deleteProductById(20);
        System.out.println(productDao.getProductById(20));

        cartDao.addProductToCart(20,5);
        cartDao.addProductToCart(20,12);
        cartDao.addProductToCart(20,16);
        System.out.println(cartDao.getCartId(20));
        cartDao.deleteProductByIdFromCart(20, 5);
        System.out.println(cartDao.getCartId(20));
        cartDao.deleteCartById(20);


    }
}

