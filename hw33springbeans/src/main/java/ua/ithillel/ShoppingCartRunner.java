package ua.ithillel;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.ithillel.beans.Cart;
import ua.ithillel.beans.ProductRepository;
import ua.ithillel.entities.Product;

import java.util.ArrayList;
import java.util.List;;
import java.util.Scanner;

public class ShoppingCartRunner {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("ua.ithillel");

        ProductRepository productRepository = context.getBean(ProductRepository.class);
        Scanner input = new Scanner(System.in);
        List<Cart> carts = new ArrayList<>();
        int id;
        String inpt;

        productRepository.addProduct(new Product(1, "Milk", 42.40));
        productRepository.addProduct(new Product(2, "Sugar", 48.50));
        productRepository.addProduct(new Product(3, "Pasta", 68.20));
        productRepository.addProduct(new Product(4, "Chocolate", 40));
        productRepository.addProduct(new Product(5, "Ketchup", 38.20));
        productRepository.addProduct(new Product(6, "Potato", 12.50));
        productRepository.addProduct(new Product(7, "Tomamto", 120.78));
        productRepository.addProduct(new Product(8, "Burak", 22.20));
        productRepository.addProduct(new Product(9, "Bread", 27.00));
        productRepository.addProduct(new Product(10, "Water", 38.60));
        productRepository.addProduct(new Product(11, "Eggs", 67.20));
        productRepository.addProduct(new Product(12, "Butter", 78.80));


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

        if (!carts.isEmpty()) {
            System.out.println("Your total order: ");
            carts.stream().forEach(System.out::println);
        }
    }
}

