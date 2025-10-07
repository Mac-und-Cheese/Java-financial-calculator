import java.util.Scanner;
public class HistoricalData {
    private Scanner scanner;
    private double[] historicalReturns;
    private int returnCount;
    private static final int MAX_SIZE = 1000;
    
    public HistoricalData(Scanner scanner) {
        this.scanner = scanner;
        this.historicalReturns = new double[MAX_SIZE];
        this.returnCount = 0;
    }
    
    public void showDataManagementMenu() {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\n--- HISTORICAL DATA MANAGEMENT ---");
            System.out.println("1. Add Historical Returns");
            System.out.println("2. View Current Historical Data");
            System.out.println("3. Clear Historical Data");
            System.out.println("4. Back to Main Menu");
            
            int choice = Input.getIntInput(scanner, "Choose option: ", 1, 4);
            
            switch (choice) {
                case 1:
                    addHistoricalReturns();
                    break;
                case 2:
                    viewHistoricalData();
                    break;
                case 3:
                    clearHistoricalData();
                    break;
                case 4:
                    inMenu = false;
                    break;
            }
        }
    }
    
    public void addHistoricalReturns() {
        System.out.println("\n--- ADD HISTORICAL RETURNS ---");
        int count = Input.getIntInput(scanner, "How many return values to add? ", 1, MAX_SIZE - returnCount);
        
        System.out.println("Enter returns as decimals (e.g., 0.05 for 5%):");
        for (int i = 0; i < count; i++) {
            double returnValue = Input.getDoubleInput(scanner, String.format("Return #%d: ", i + 1));
            if (returnCount < MAX_SIZE) {
                historicalReturns[returnCount] = returnValue;
                returnCount++;
            }
        }
        
        System.out.printf("Added %d returns. Total: %d%n", count, returnCount);
        Input.waitForUser(scanner);
    }
    
    public void viewHistoricalData() {
        System.out.println("\n--- CURRENT HISTORICAL DATA ---");
        if (returnCount == 0) {
            System.out.println("No historical data available.");
        } else {
            System.out.println("Historical Returns (" + returnCount + " entries):");
            for (int i = 0; i < returnCount; i++) {
                System.out.printf("Period %2d: %6.2f%%%n", i + 1, historicalReturns[i] * 100);
            }
        }
        Input.waitForUser(scanner);
    }
    
    public void clearHistoricalData() {
        if (Input.getConfirmation(scanner, "Clear all historical data?")) {
            returnCount = 0;
            System.out.println("All historical data cleared.");
        } else {
            System.out.println("Operation cancelled.");
        }
        Input.waitForUser(scanner);
    }
    
    public double[] getHistoricalReturnsArray() {
        double[] currentReturns = new double[returnCount];
        for(int i = 0; i < returnCount; i++) {
            currentReturns[i] = historicalReturns[i];
        }
        return currentReturns;
    }
    
    public int getDataCount() {
        return returnCount;
    }
}