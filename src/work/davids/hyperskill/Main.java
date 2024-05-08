package work.davids.hyperskill;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize and declare variables for earnings
        int bubblegumEarnings = 202;
        int toffeeEarnings = 118;
        int iceCreamEarnings = 2250;
        int milkChocolateEarnings = 1680;
        int doughnutEarnings = 1075;
        int pancakeEarnings = 80;

        // Calculate the total income from all items
        int totalIncome = bubblegumEarnings + toffeeEarnings + iceCreamEarnings +
                milkChocolateEarnings + doughnutEarnings + pancakeEarnings;

        // Display the earnings for each item
        displayEarnings(bubblegumEarnings, toffeeEarnings, iceCreamEarnings,
                milkChocolateEarnings, doughnutEarnings, pancakeEarnings);

        // Display the total income
        System.out.println("Income: $" + totalIncome);

        // Create a Scanner object to take user input for expenses
        Scanner scanner = new Scanner(System.in);

        // Ask for and read staff expenses from user
        System.out.print("Staff expenses: ");
        int staffExpenses = scanner.nextInt();

        // Ask for and read other expenses from user
        System.out.print("Other expenses: ");
        int otherExpenses = scanner.nextInt();

        // Calculate and display net income
        int netIncome = calculateNetIncome(totalIncome, staffExpenses, otherExpenses);
        System.out.println("Net income: $" + netIncome);

        // Close the scanner to prevent resource leaks
        scanner.close();
    }

    // Method to display the earnings for each item
    private static void displayEarnings(int... earnings) {
        System.out.println("Earned amount:");
        String[] items = {"Bubblegum", "Toffee", "Ice cream", "Milk chocolate", "Doughnut", "Pancake"};
        for (int i = 0; i < earnings.length; i++) {
            System.out.println(items[i] + ": $" + earnings[i]);
        }
        // Adds a blank line for clearer separation in output
        System.out.println();
    }

    // Method to calculate net income
    private static int calculateNetIncome(int totalIncome, int staffExpenses, int otherExpenses) {
        return totalIncome - staffExpenses - otherExpenses;
    }
}