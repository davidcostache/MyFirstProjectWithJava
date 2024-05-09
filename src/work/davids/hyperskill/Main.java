package work.davids.hyperskill;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static final HashMap<String, Integer> earningsMap = new HashMap<>();

    static {
        earningsMap.put("Bubblegum", 202);
        earningsMap.put("Toffee", 118);
        earningsMap.put("Ice Cream", 2250);
        earningsMap.put("Milk Chocolate", 1680);
        earningsMap.put("Doughnut", 1075);
        earningsMap.put("Pancake", 80);
    }

    public static void main(String[] args) {
        // Calculate and display the total earnings
        int totalIncome = calculateTotalEarnings();
        displayEarnings();

        // Display the total income
        System.out.printf("Total Income: $%,d%n", totalIncome);

        // Read and handle expenses
        Scanner scanner = new Scanner(System.in);
        int staffExpenses = readExpense(scanner, "Staff expenses: ");
        int otherExpenses = readExpense(scanner, "Other expenses: ");
        scanner.close();

        // Calculate and display net income
        int netIncome = calculateNetIncome(totalIncome, staffExpenses, otherExpenses);
        System.out.printf("Net Income: $%,d%n", netIncome);
    }

    private static int calculateTotalEarnings() {
        return earningsMap.values().stream().mapToInt(Integer::intValue).sum();
    }

    private static void displayEarnings() {
        System.out.println("Earned amount:");
        earningsMap.forEach((item, amount) -> System.out.printf("%s: $%,d%n", item, amount));
        System.out.println();
    }

    private static int readExpense(Scanner scanner, String prompt) {
        int expense;
        do {
            System.out.print(prompt);
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input, please enter a number.");
                scanner.next(); // consume the non-integer input
                System.out.print(prompt);
            }
            expense = scanner.nextInt();
            if (expense < 0) {
                System.out.println("Please enter a non-negative number.");
            }
        } while (expense < 0);
        return expense;
    }

    private static int calculateNetIncome(int totalIncome, int staffExpenses, int otherExpenses) {
        return totalIncome - staffExpenses - otherExpenses;
    }
}