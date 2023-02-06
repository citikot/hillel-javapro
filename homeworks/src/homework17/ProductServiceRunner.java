package homework17;

import java.time.LocalDate;
import java.util.List;

public class ProductServiceRunner {
    public static void main(String[] args){
        List<Product> listOfProducts = List.of(
                new Product(1, "Book", 60, false, LocalDate.of(2019, 11, 1)),
                new Product(2, "Toy", 180, true, LocalDate.of(2019, 10, 15)),
                new Product(3, "Toy", 300, false, LocalDate.of(2019, 7, 18)),
                new Product(4, "Book", 280, true, LocalDate.of(2019, 7, 25)),
                new Product(5, "Toy", 300, true, LocalDate.of(2020, 1, 30)),
                new Product(6, "Book", 50, false, LocalDate.of(2019, 1, 18)),
                new Product(7, "Toy", 1180, true, LocalDate.of(2019, 8, 12)),
                new Product(8, "Book", 150, false, LocalDate.of(2019, 5, 11)),
                new Product(9, "Toy", 715, true, LocalDate.of(2020, 2, 15)),
                new Product(10, "Book", 100, false, LocalDate.of(2019, 6, 14)),
                new Product(11, "Toy", 550, true, LocalDate.of(2020, 3, 8)),
                new Product(12, "Book", 380, false, LocalDate.of(2019, 4, 12)),
                new Product(13, "Stationery", 400, false, LocalDate.of(2019, 12, 20)),
                new Product(14, "Book", 120, false, LocalDate.of(2020, 1, 4)),
                new Product(15, "Toy", 980, true, LocalDate.of(2019, 9, 22)),
                new Product(16, "Book", 410, false, LocalDate.of(2019, 6, 14)),
                new Product(17, "Book", 110, false, LocalDate.of(2019, 12, 2)),
                new Product(18, "Book", 60, true, LocalDate.of(2020, 2, 3)),
                new Product(19, "Toy", 1000, true, LocalDate.of(2019, 12, 5))
        );

        System.out.println(ProductService.task12(listOfProducts));
        System.out.println(ProductService.task22(listOfProducts));
        System.out.println(ProductService.task42(listOfProducts));
        System.out.println(ProductService.task32(listOfProducts, "abc"));
        System.out.println(ProductService.task52(listOfProducts, "Book", 75.0, LocalDate.of(2019, 12, 30)));
    }
}
