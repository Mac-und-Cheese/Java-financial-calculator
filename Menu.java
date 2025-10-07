import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private RatioCal ratioC;
    private ReturnCal returnC;
    private RiskCal riskC;
    private HistoricalData historicalD;
    private boolean contiune;
    
    public Menu() {
        this.scanner = new Scanner(System.in);
        this.ratioC = new RatioCal(scanner);
        this.returnC = new ReturnCal(scanner);
        this.riskC = new RiskCal(scanner);
        this.historicalD = new HistoricalData(scanner);
        this.contiune = true;
    }
    
    public void start() {
        displayWelcomeMessage();
        
        while (contiune) {
            displayMainMenu();
            int choice = Input.getIntInput(scanner, "Please enter your choice (0-5): ", 0, 5);
            processUserChoice(choice);
        }
        
        displayGoodbyeMessage();
        scanner.close();
    }
    
    private void displayWelcomeMessage() {
        System.out.println("====================================");
        System.out.println("         FINANCIAL CALCULATOR       ");
        System.out.println("====================================");
        System.out.println("Welcome! This program helps you analyze");
        System.out.println("financial ratios, returns, and risk metrics.");
    }
    
    private void displayMainMenu() {
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("1. Calculate Financial Ratios");
        System.out.println("2. Calculate Investment Returns");
        System.out.println("3. Calculate Risk Metrics");
        System.out.println("4. View/Manage Historical Data");
        System.out.println("5. Comprehensive Analysis");
        System.out.println("0. Exit Program");//can you see this?
    }
    
    private void processUserChoice(int choice) {
        switch (choice) {
            case 1:
                ratioC.showRatioMenu();
                break;
            case 2:
                returnC.showReturnsMenu();
                break;
            case 3:
                riskC.showRiskMenu();
                break;
            case 4:
                historicalD.showDataManagementMenu();
                break;
            case 5:
                runComprehensiveAnalysis();
                break;
            case 0:
                contiune = false;
                break;
        }
    }
    
    private void runComprehensiveAnalysis() {
        System.out.println("\n--- COMPREHENSIVE FINANCIAL ANALYSIS ---");
        // more methods can be called here
        ratioC.calculateProfitabilityRatios();
        riskC.calculateRiskMetrics();
    }
    
    private void displayGoodbyeMessage() {
        System.out.println("\n====================================");
        System.out.println("||      Thank you for using       ||");
        System.out.println("||      Financial Calculator      ||");
        System.out.println("====================================");
        System.out.println("Created by: Me");
        System.out.println("\n\n\nOkaaay, maybe a little help from Copilot");
        System.out.println("Me refers to Mac-und-Cheese");
    }
}