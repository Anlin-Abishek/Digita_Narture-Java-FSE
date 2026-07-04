public class DecoratorTest {
    public static void main(String[] args) {
        Notifier emailOnly = new EmailNotifier();
        
        Notifier emailAndSMS = new SMSNotifierDecorator(new EmailNotifier());
        
        Notifier allChannels = new SlackNotifierDecorator(
                                    new SMSNotifierDecorator(
                                        new EmailNotifier()
                                    )
                               );

        System.out.println("--- Scenario 1: Email Only ---");
        emailOnly.send("System Alert!");

        System.out.println("\n--- Scenario 2: Email + SMS ---");
        emailAndSMS.send("System Alert!");

        System.out.println("\n--- Scenario 3: Email + SMS + Slack ---");
        allChannels.send("System Alert!");
    }
}
