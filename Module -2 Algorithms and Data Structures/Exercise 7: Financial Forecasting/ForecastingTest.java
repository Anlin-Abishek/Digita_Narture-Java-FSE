public class ForecastingTest {
    public static void main(String[] args) {
        double initialInvestment = 1000.00;
        double annualGrowthRate = 0.05;
        int forecastYears = 5;

        double futureValue = FinancialForecasting.calculateFutureValue(initialInvestment, annualGrowthRate, forecastYears);

        System.out.printf("Initial Investment: $%.2f%n", initialInvestment);
        System.out.printf("Annual Growth Rate: %.1f%%%n", (annualGrowthRate * 100));
        System.out.printf("Forecasted Value after %d years: $%.2f%n", forecastYears, futureValue);
    }
}
