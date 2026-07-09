public class InventoryTest {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        Product p1 = new Product("P001", "Laptop", 10, 999.99);
        Product p2 = new Product("P002", "Smartphone", 50, 499.99);
        inventory.addProduct(p1);
        inventory.addProduct(p2);

        System.out.println("--- Initial Inventory ---");
        inventory.displayInventory();

        System.out.println("\n--- Updating Laptop Stock ---");
        inventory.updateProduct("P001", 8, 949.99);
        System.out.println(inventory.getProduct("P001"));

        System.out.println("\n--- Deleting Smartphone ---");
        inventory.deleteProduct("P002");
        inventory.displayInventory();
    }
}
