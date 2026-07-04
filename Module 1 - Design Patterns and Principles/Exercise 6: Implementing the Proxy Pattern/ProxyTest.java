public class ProxyTest {
    public static void main(String[] args) {
        Image image = new ProxyImage("high_res_photo.png");

        System.out.println("--- First Call: Display Image ---");
        image.display();

        System.out.println("\n--- Second Call: Display Image Again ---");
        image.display();
    }
}
