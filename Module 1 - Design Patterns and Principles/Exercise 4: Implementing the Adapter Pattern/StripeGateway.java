public class StripeGateway {
    public void captureCharge(int amountInCents) {
        System.out.println("Processing charge of " + amountInCents + " cents via Stripe.");
    }
}
