package homework17;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class ProductService {

    public static List<Product> task12(List<Product> listOfProducts) {
        return listOfProducts.stream()
                .filter(elem -> Objects.equals(elem.getType(), "Book"))
                .filter(elem -> elem.getPrice() > 250)
                .collect(Collectors.toList());
    }

    public static List<Product> task22(List<Product> listOfProducts) {
        List<Product> books = listOfProducts.stream()
                .filter(elem -> Objects.equals(elem.getType(), "Book"))
                .filter(Product::isDiscount)
                .collect(Collectors.toList());

        for (int i = 0; i < books.size(); i++) {
            books.get(i).setPrice(books.get(i).getPrice() * 0.9);
        }
        return books;
    }

    public static OptionalDouble task32(List<Product> listOfProducts, String category) {
        OptionalDouble min = listOfProducts.stream()
                .filter(elem -> Objects.equals(elem.getType(), category))
                .mapToDouble(Product::getPrice)
                .min();
        try {
            if (min.isEmpty()) {
                throw new CategoryException(category);
            }
        } catch (CategoryException e) {
            System.out.println(e.getMessage());
        }
        return min;
    }

    public static List<Product> task42(List<Product> listOfProducts) {
        return listOfProducts.stream()
                .sorted(Comparator.comparing(Product::getCreateDate))
                .skip(listOfProducts.size() - 3)
                .collect(Collectors.toList());
    }

    public static Double task52(List<Product> listOfProducts, String category, Double priceLimit, LocalDate
            dateLimit) {
        return listOfProducts.stream()
                .filter(elem -> elem.getType().equals(category))
                .filter(elem -> elem.getPrice() < priceLimit)
                .filter(elem -> elem.getCreateDate().isBefore(dateLimit))
                .mapToDouble(Product::getPrice)
                .sum();
    }
}
