import java.util.Scanner;

public class Input {
    
    public static int getIntInput(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                scanner.nextLine(); 
                if (input >= min && input <= max) {
                    return input;
                }
            } else {
                scanner.next();
            }
            System.out.printf("Invalid input! Please enter a number between %d and %d.%n", min, max);
        }
    }
    
    public static double getDoubleInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                double input = scanner.nextDouble();
                scanner.nextLine(); 
                return input;
            } else {
                scanner.next();
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }
    
    public static void waitForUser(Scanner scanner) {
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
    }
    
    public static boolean getConfirmation(Scanner scanner, String prompt) {
        System.out.print(prompt + " (y/n): ");
        String input = scanner.nextLine().trim().toLowerCase();
        return input.equals("y") || input.equals("yes");//testing
    }
}