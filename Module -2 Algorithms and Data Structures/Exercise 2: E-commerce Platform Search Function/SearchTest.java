import java.util.Arrays;

public class SearchTest {
    public static void main(String[] args) {
        Product[] products = {
            new Product("P105", "Wireless Mouse", "Electronics"),
            new Product("P101", "Mechanical Keyboard", "Electronics"),
            new Product("P103", "Gaming Monitor", "Electronics"),
            new Product("P102", "USB-C Cable", "Accessories")
        };

        System.out.println("--- Linear Search Demonstration ---");
        Product result1 = SearchUtil.linearSearch(products, "P103");
        System.out.println("Found via Linear Search: " + result1);

        Arrays.sort(products);

        System.out.println("\n--- Binary Search Demonstration ---");
        Product result2 = SearchUtil.binarySearch(products, "P103");
        System.out.println("Found via Binary Search: " + result2);
    }
}
