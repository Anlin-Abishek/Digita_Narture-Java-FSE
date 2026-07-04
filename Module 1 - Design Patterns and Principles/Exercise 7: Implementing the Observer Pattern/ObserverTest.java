public class ObserverTest {
    public static void main(String[] args) {
        StockMarket techMarket = new StockMarket();

        Observer mobileDisplay = new MobileApp();
        Observer webDisplay = new WebApp();

        techMarket.registerObserver(mobileDisplay);
        techMarket.registerObserver(webDisplay);

        System.out.println("--- First Price Update ---");
        techMarket.setStockData("AAPL", 175.50);

        System.out.println("\n--- Second Price Update ---");
        techMarket.setStockData("GOOGL", 2800.25);

        System.out.println("\n--- Mobile App Unsubscribes ---");
        techMarket.removeObserver(mobileDisplay);

        System.out.println("\n--- Third Price Update ---");
        techMarket.setStockData("MSFT", 420.10);
    }
}
