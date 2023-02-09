package homework17;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class ProductUtils {

    private ProductUtils() {
    }

    public static List<Product> task12(List<Product> listOfProducts) {
        return listOfProducts.stream()
                .filter(elem -> "Book".equals(elem.getType()))
                .filter(elem -> elem.getPrice() > 250)
                .toList();
    }

    public static List<Product> task22(List<Product> listOfProducts) {
        return listOfProducts.stream()
                .filter(elem -> "Book".equals(elem.getType()))
                .filter(Product::isDiscount)
                .map(elem -> new Product(elem.getId(), elem.getType(), elem.getPrice() * 0.9, elem.isDiscount(), elem.getCreateDate()))
                .toList();

    }

    public static OptionalDouble task32(List<Product> listOfProducts, String category) {
        return OptionalDouble.of(listOfProducts.stream()
                .filter(elem -> category.equals(elem.getType()))
                .mapToDouble(Product::getPrice)
                .min()
                .orElseThrow(() -> new CategoryException(category)));
    }

    public static List<Product> task42(List<Product> listOfProducts) {
        return listOfProducts.stream()
                .sorted(Comparator.comparing(Product::getCreateDate).reversed())
                .limit(3)
                .toList();
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

    public static Map<String, List<Product>> task62(List<Product> listOfProducts) {
        Map<String, List<Product>> sortedDict = listOfProducts.stream()
                .collect(Collectors.groupingBy(Product::getType));
        return sortedDict;
    }
}

