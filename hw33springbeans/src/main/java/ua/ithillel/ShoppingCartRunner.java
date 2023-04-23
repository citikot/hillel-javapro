package ua.ithillel;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.ithillel.beans.Cart;
import ua.ithillel.beans.ProductRepository;

import java.util.ArrayList;
import java.util.List;;
import java.util.Scanner;

public class ShoppingCartRunner {
    public static void main(String[] args) {

        ConfigurableApplicationContext appContext = new AnnotationConfigApplicationContext("ua.ithillel");
        ProductRepository productRepository = appContext.getBean(ProductRepository.class);
        List<Cart> carts = new ArrayList<>();

        processCarts(carts, productRepository, appContext);
        printCarts(carts);
    }

static void processCarts(List<Cart> carts, ProductRepository productRepository, ConfigurableApplicationContext context) {
    int id;
    String inpt;
    Scanner input = new Scanner(System.in);

    while (true) {
        System.out.print("To continue shopping, enter any symbol, to finish shopping, enter N: ");
        if (input.hasNext()) {
            inpt = input.next();
            if (("N".equals(inpt)) || ("n".equals(inpt))) {
                break;
            }
        }

        Cart workingCart = context.getBean(Cart.class);

        while (true) {

            System.out.println("Available products: " + productRepository.getAllProducts());
            System.out.print("Please, choose product from 1 to 12 to add the current card: ");
            if (input.hasNextInt()) {
                id = input.nextInt();
                if (id >= 1 && id <= 12) {
                    workingCart.addProductById(id, productRepository);
                }
            }

            while (true) {
                if (workingCart.getCartContent().isEmpty()) {
                    System.out.println("You cart is empty.");
                    break;
                }
                System.out.println("You cart consists the following products:");
                System.out.println(workingCart.getCartContent());
                System.out.print("To remove some products, enter product id, to continue, enter 0 (zero): ");
                if (input.hasNextInt()) {
                    id = input.nextInt();
                    if (id == 0) {
                        break;
                    }
                    workingCart.deleteProductById(id, productRepository);
                }
            }

            System.out.print("To stop making new Cart, press N: ");

            if (input.hasNext()) {
                inpt = input.next();
                if (("N".equals(inpt)) || ("n".equals(inpt))) {
                    break;
                }
            }
        }
        carts.add(workingCart);
    }
}

    static void printCarts(List<Cart> carts) {
        if (!carts.isEmpty()) {
            System.out.println("Your total order: ");
            carts.forEach(System.out::println);
        }
    }
}

