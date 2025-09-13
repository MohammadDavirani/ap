package finalExam;

import java.util.*;
import java.util.stream.Collectors;

public class ProductTools {

    public static void displayProductsInformation(List<Product> products){
        List<Product> newProducts = products.stream()
                .distinct()
                .collect(Collectors.toList());

        newProducts.forEach(System.out::println);
    }

    public static Map<String, Product> expensiveBookAndPen(List<Product> products) {
        Product expensiveBook = products.stream()
                .filter(p -> p.getName().equalsIgnoreCase("Book"))
                .max(Comparator.comparingInt(Product::getPrice))
                .orElse(null);

        Product expensivePen = products.stream()
                .filter(p -> p.getName().equalsIgnoreCase("Pen"))
                .max(Comparator.comparingInt(Product::getPrice))
                .orElse(null);

        Map<String, Product> result = new HashMap<>();
        result.put("Book", expensiveBook);
        result.put("Pen", expensivePen);

        return result;
    }
}
