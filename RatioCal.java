import java.util.Scanner;

public class RatioCal {
    private Scanner scanner;
    
    public RatioCal(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public void showRatioMenu() {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\n--- FINANCIAL RATIOS CALCULATION ---");
            System.out.println("1. Liquidity Ratios");
            System.out.println("2. Profitability Ratios");
            System.out.println("3. Solvency Ratios");
            System.out.println("4. Back to Main Menu");
            
            int choice = Input.getIntInput(scanner, "Choose ratio type: ", 1, 4);
            
            switch (choice) {
                case 1:
                    calculateLiquidityRatios();
                    break;
                case 2:
                    calculateProfitabilityRatios();
                    break;
                case 3:
                    calculateSolvencyRatios();
                    break;
                case 4:
                    inMenu = false;
                    break;
            }
        }
    }
    
    public void calculateLiquidityRatios() {
        System.out.println("\n--- LIQUIDITY RATIOS ---");
        
        double currentAssets = Input.getDoubleInput(scanner, "Enter current assets: ");
        double currentLiabilities = Input.getDoubleInput(scanner, "Enter current liabilities: ");
        double inventory = Input.getDoubleInput(scanner, "Enter inventory (for quick ratio): ");
        double cash = Input.getDoubleInput(scanner, "Enter cash (for cash ratio): ");
        
        Data data = new Data.Builder()
            .setCurrentAssets(currentAssets)
            .setCurrentLiabilities(currentLiabilities)
            .setInventory(inventory)
            .setCash(cash)
            .build();

        
        double currentRatio = LiquidityRatios.calculateCurrentRatio(data);
        double quickRatio = LiquidityRatios.calculateQuickRatio(data, inventory);
        double cashRatio = LiquidityRatios.calculateCashRatio(data, cash);
        
        displayLiquidityResults(currentRatio, quickRatio, cashRatio);
        Input.waitForUser(scanner);
    }
    
    public void calculateProfitabilityRatios() {
        System.out.println("\n--- PROFITABILITY RATIOS ---");
        
        double netIncome = Input.getDoubleInput(scanner, "Enter net income: ");
        double totalAssets = Input.getDoubleInput(scanner, "Enter total assets: ");
        double equity = Input.getDoubleInput(scanner, "Enter equity: ");
        double revenue = Input.getDoubleInput(scanner, "Enter revenue: ");
        double costOfGoodsSold = Input.getDoubleInput(scanner, "Enter cost of goods sold: ");
        Data data = new Data.Builder()
            .setNetIncome(netIncome)
            .setTotalAssets(totalAssets)
            .setEquity(equity)
            .setRevenue(revenue)
            .setCostOfGoodsSold(costOfGoodsSold)
            .build();
        
        double roa = ProfitabilityRatios.calculateReturnOnAssets(data);
        double roe = ProfitabilityRatios.calculateReturnOnEquity(data);
        double profitMargin = ProfitabilityRatios.calculateProfitMargin(data);
        double grossMargin = ProfitabilityRatios.calculateGrossMargin(data, costOfGoodsSold);
        
        displayProfitabilityResults(roa, roe, profitMargin, grossMargin);
        Input.waitForUser(scanner);
    }
    
    public void calculateSolvencyRatios() {
        System.out.println("\n--- SOLVENCY RATIOS ---");
        
        double totalAssets = Input.getDoubleInput(scanner, "Enter total assets: ");
        double totalLiabilities = Input.getDoubleInput(scanner, "Enter total liabilities: ");
        double equity = Input.getDoubleInput(scanner, "Enter equity: ");
        double ebit = Input.getDoubleInput(scanner, "Enter EBIT: ");
        double interestExpense = Input.getDoubleInput(scanner, "Enter interest expense: ");
        
        Data data = new Data.Builder()
            .setTotalAssets(totalAssets)
            .setTotalLiabilities(totalLiabilities)
            .setEquity(equity)
            .build();
        
        double debtToEquity = SolvencyRatios.calculateDebtToEquity(data);
        double debtRatio = SolvencyRatios.calculateDebtRatio(data);
        double interestCoverage = SolvencyRatios.calculateInterestCoverage(ebit, interestExpense);
        
        displaySolvencyResults(debtToEquity, debtRatio, interestCoverage);
        Input.waitForUser(scanner);
    }
    
    private void displayLiquidityResults(double currentRatio, double quickRatio, double cashRatio) {
        System.out.println("\n--- LIQUIDITY RESULTS ---");
        System.out.printf("Current Ratio: %.2f%n", currentRatio);
        System.out.printf("Quick Ratio: %.2f%n", quickRatio);
        System.out.printf("Cash Ratio: %.2f%n", cashRatio);
    }
    
    private void displayProfitabilityResults(double roa, double roe, double profitMargin, double grossMargin) {
        System.out.println("\n--- PROFITABILITY RESULTS ---");
        System.out.printf("Return on Assets (ROA): %.2f%%%n", roa * 100);
        System.out.printf("Return on Equity (ROE): %.2f%%%n", roe * 100);
        System.out.printf("Profit Margin: %.2f%%%n", profitMargin * 100);
        System.out.printf("Gross Margin: %.2f%%%n", grossMargin * 100);
    }
    
    private void displaySolvencyResults(double debtToEquity, double debtRatio, double interestCoverage) {
        System.out.println("\n--- SOLVENCY RESULTS ---");
        System.out.printf("Debt to Equity Ratio: %.2f%n", debtToEquity);
        System.out.printf("Debt Ratio: %.2f%n", debtRatio);
        System.out.printf("Interest Coverage Ratio: %.2f%n", interestCoverage);
    }
}