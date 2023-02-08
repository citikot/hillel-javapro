package homework17;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class ProductUtils {

    public static List<Product> task12(List<Product> listOfProducts) {
        return listOfProducts.stream()
                .filter(elem -> "Book".equals(elem.getType()))
                .filter(elem -> elem.getPrice() > 250)
                .collect(Collectors.toList());
    }

    public static List<Product> task22(List<Product> listOfProducts) {
        List<Product> books = listOfProducts.stream()
                .filter(elem -> "Book".equals(elem.getType()))
                .filter(Product::isDiscount)
                .map(elem -> new Product(elem.getId(), elem.getType(), elem.getPrice() * 0.9, elem.isDiscount(),elem.getCreateDate() ))
                .collect(Collectors.toList());

        return books;
    }

    public static OptionalDouble task32(List<Product> listOfProducts, String category) {
        OptionalDouble min = listOfProducts.stream()
                .filter(elem -> category.equals(elem.getType()))
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
                .sorted(Comparator.comparing(Product::getCreateDate).reversed())
                .limit(3)
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
