import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        Order[] ordersForBubble = {
            new Order("O001", "Alice", 250.50),
            new Order("O002", "Bob", 89.99),
            new Order("O003", "Charlie", 1200.00),
            new Order("O004", "David", 450.00)
        };

        Order[] ordersForQuick = Arrays.copyOf(ordersForBubble, ordersForBubble.length);

        System.out.println("--- Executing Bubble Sort ---");
        SortUtil.bubbleSort(ordersForBubble);
        for (Order order : ordersForBubble) {
            System.out.println(order);
        }

        System.out.println("\n--- Executing Quick Sort ---");
        SortUtil.quickSort(ordersForQuick, 0, ordersForQuick.length - 1);
        for (Order order : ordersForQuick) {
            System.out.println(order);
        }
    }
}
