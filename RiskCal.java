import java.util.Scanner;
public class RiskCal {
    private Scanner scanner;
    private HistoricalData dataService;
    
    public RiskCal(Scanner scanner) {
        this.scanner = scanner;
        this.dataService = new HistoricalData(scanner);
    }
    
    public void showRiskMenu() {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\n--- RISK METRICS ---");
            System.out.println("1. Calculate Standard Deviation & Variance");
            System.out.println("2. Calculate Sharpe Ratio");
            System.out.println("3. Add/View Historical Data");
            System.out.println("4. Back to Main Menu");
            
            int choice = Input.getIntInput(scanner, "Choose option: ", 1, 4);
            
            switch (choice) {
                case 1:
                    calculateRiskMetrics();
                    break;
                case 2:
                    calculateSharpeRatio();
                    break;
                case 3:
                    dataService.showDataManagementMenu();
                    break;
                case 4:
                    inMenu = false;
                    break;
            }
        }
    }
    
    public void calculateRiskMetrics() {
        double[] returns = dataService.getHistoricalReturnsArray();
        
        if (returns.length < 2) {
            System.out.println("Need at least 2 historical returns for risk calculation.");
            System.out.println("Please add more data first.");
            Input.waitForUser(scanner);
            return;
        }
        
        double stdDev = calculateStandardDeviation(returns);
        double variance = calculateVariance(returns);
        double avgReturn = calculateAverageReturn(returns);
        
        System.out.println("\n--- RISK METRICS RESULTS ---");
        System.out.println("Using " + returns.length + " historical returns");
        System.out.printf("Average Return: %.2f%%%n", avgReturn * 100);
        System.out.printf("Standard Deviation: %.2f%%%n", stdDev * 100);
        System.out.printf("Variance: %.6f%n", variance);
        
        Input.waitForUser(scanner);
    }
    
    private void calculateSharpeRatio() {
        double[] returns = dataService.getHistoricalReturnsArray();
        
        if (returns.length < 2) {
            System.out.println("Need historical data for Sharpe ratio calculation.");
            return;
        }
        
        double riskFreeRate = Input.getDoubleInput(scanner, "Enter risk-free rate (as decimal): ");
        double avgReturn = calculateAverageReturn(returns);
        double stdDev = calculateStandardDeviation(returns);
        
        double sharpeRatio = calculateSharpeRatio(avgReturn, riskFreeRate, stdDev);
        
        System.out.println("\n--- SHARPE RATIO RESULTS ---");
        System.out.printf("Sharpe Ratio: %.2f%n", sharpeRatio);
        
        Input.waitForUser(scanner);
    }
    public static double calculateStandardDeviation(double[] returns) {
        double mean = calculateAverageReturn(returns);
        double sumSquaredDiffs = 0.0;
        for (double r : returns) {
            sumSquaredDiffs += Math.pow(r - mean, 2);
        }
        return Math.sqrt(sumSquaredDiffs / (returns.length - 1));
    }
    public static double calculateVariance(double[] returns) {
        double mean = calculateAverageReturn(returns);
        double sumSquaredDiffs = 0.0;
        for (double r : returns) {
            sumSquaredDiffs += Math.pow(r - mean, 2);
        }
        return sumSquaredDiffs / (returns.length - 1);
    }
    public static double calculateAverageReturn(double[] returns) {
        double sum = 0.0;
        for (int i = 0; i < returns.length; i++) {
            sum += returns[i];
        }
        return sum / returns.length;
    }
    public static double calculateSharpeRatio(double avgReturn, double riskFreeRate, double stdDev) {
        if (stdDev == 0) return 0;
         // Avoid division by zero
        return (avgReturn - riskFreeRate) / stdDev;
    }
}