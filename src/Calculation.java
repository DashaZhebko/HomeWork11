import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Calculation {
    public static List<Product> getBooksWithPrice(List<Product> products) {
        return products.stream()
                .filter(p -> p.getProductType().equals("Book"))
                .filter(p -> p.getPrice() > 250)
                .toList();
    }

    public static List<Product> getDiscountedBooks(List<Product> products) {
        return products.stream()
                .filter(product -> product.getProductType().equals("Book") && product.isSetDiscount())
                .toList();
    }

    public static Product getCheapestBook(List<Product> products) {
        return products.stream()
                .filter(p -> p.getProductType().equals("Book"))
                .min(Comparator.comparing(Product::getPrice))
                .orElseThrow(() -> new NoSuchElementException("Product [category: Book] not found"));
    }

    public static List<Product> getLastThreeProducts(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getDateCreate).reversed())
                .limit(3)
                .toList();
    }

    public static double getBooksSum(List<Product> products) {
        return products.stream()
                .filter(p -> p.getDateCreate().getYear() == LocalDate.now().getYear())
                .filter(p -> p.getProductType().equals("Book"))
                .filter(p -> p.getPrice() < 75.0)
                .mapToDouble(Product::getPrice)
                .sum();

    }

    public static Map<String, List<Product>> getProductsGroups(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getProductType));
    }
}
