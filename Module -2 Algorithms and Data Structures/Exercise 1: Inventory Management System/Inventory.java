import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<String, Product> productMap = new HashMap<>();

    public void addProduct(Product product) {
        productMap.put(product.getProductId(), product);
    }

    public Product getProduct(String productId) {
        return productMap.get(productId);
    }

    public void updateProduct(String productId, int newQuantity, double newPrice) {
        Product product = productMap.get(productId);
        if (product != null) {
            product.setQuantity(newQuantity);
            product.setPrice(newPrice);
        }
    }

    public void deleteProduct(String productId) {
        productMap.remove(productId);
    }

    public void displayInventory() {
        for (Product product : productMap.values()) {
            System.out.println(product);
        }
    }
}
