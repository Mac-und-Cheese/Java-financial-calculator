import java.util.Scanner;

public class ReturnCal {
    private Scanner scanner;
    
    public ReturnCal(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public void showReturnsMenu() {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\n--- INVESTMENT RETURNS ---");
            System.out.println("1. Calculate Simple Return");
            System.out.println("2. Calculate Annualized Return");
            System.out.println("3. Calculate CAGR");
            System.out.println("4. Back to Main Menu");
            
            int choice = Input.getIntInput(scanner, "Choose calculation type: ", 1, 4);
            
            switch (choice) {
                case 1:
                    calculateSimpleReturn();
                    break;
                case 2:
                    calculateAnnualizedReturn();
                    break;
                case 3:
                    calculateCAGR();
                    break;
                case 4:
                    inMenu = false;
                    break;
            }
        }
    }
    
    private void calculateSimpleReturn() {
        System.out.println("\n--- SIMPLE RETURN CALCULATION ---");
        double initialValue = Input.getDoubleInput(scanner, "Enter initial investment value: ");
        double finalValue = Input.getDoubleInput(scanner, "Enter final investment value: ");
        
        double returnRate = calculateSimpleReturn(initialValue, finalValue);
        
        System.out.println("\n--- RESULTS ---");
        System.out.printf("Simple Return: %.2f%%%n", returnRate * 100);
        System.out.printf("Profit/Loss: $%.2f%n", finalValue - initialValue);
        
        Input.waitForUser(scanner);
    }
    
    private void calculateAnnualizedReturn() {
        System.out.println("\n--- ANNUALIZED RETURN CALCULATION ---");
        double initialValue = Input.getDoubleInput(scanner, "Enter initial investment value: ");
        double finalValue = Input.getDoubleInput(scanner, "Enter final investment value: ");
        int years = Input.getIntInput(scanner, "Enter number of years: ", 1, 100);
        
        double annualReturn = calculateAnnualizedReturn(initialValue, finalValue, years);
        
        System.out.println("\n--- RESULTS ---");
        System.out.printf("Annualized Return: %.2f%%%n", annualReturn * 100);
        
        Input.waitForUser(scanner);
    }
    
    private void calculateCAGR() {
        System.out.println("\n--- CAGR CALCULATION ---");
        double initialValue = Input.getDoubleInput(scanner, "Enter initial investment value: ");
        double finalValue = Input.getDoubleInput(scanner, "Enter final investment value: ");
        int periods = Input.getIntInput(scanner, "Enter number of periods: ", 1, 100);
        
        double cagr = calculateCAGR(initialValue, finalValue, periods);
        
        System.out.println("\n--- RESULTS ---");
        System.out.printf("Compound Annual Growth Rate (CAGR): %.2f%%%n", cagr * 100);
        
        Input.waitForUser(scanner);
    }
    public static double calculateSimpleReturn(double initialValue, double finalValue) {
        return (finalValue - initialValue) / initialValue;
    }
    public static double calculateAnnualizedReturn(double initialValue, double finalValue, int years) {
        return Math.pow(finalValue / initialValue, 1.0 / years) - 1;
    }
    public static double calculateCAGR(double initialValue, double finalValue, int periods) {
        return Math.pow(finalValue / initialValue, 1.0 / periods) - 1;
    } 
}