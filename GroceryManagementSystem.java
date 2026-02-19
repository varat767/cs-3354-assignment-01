import java.util.Scanner;

/**
 * Grocery Management System
 * CS3354 Assignment 1
 *
 * This program manages grocery inventory using parallel arrays.
 */
public class GroceryManagementSystem {

    public static void printInventory(String[] names, double[] prices, int[] stocks) {

        for (int i = 0; i < names.length; i++) {
            if (names[i] != null) {
                System.out.println("Item: " + names[i]);
                System.out.println("Price: $" + prices[i]);
                System.out.println("Stock: " + stocks[i]);
                System.out.println("---------------------");
            }
        }

    }

    // Task 2 (Student 2 will complete)
    public static void restockItem(String[] names, int[] stocks, String target, int amount) {
        boolean found = false;

        for (int i = 0; i < names.length; i++) {
            if (names[i] != null && names[i].equalsIgnoreCase(target)) {
                stocks[i] += amount;
                found = true;
                System.out.println("Restocked \"" + names[i] + "\". New stock: " + stocks[i]);
                break;
            }
        }

        if (!found) {
            System.out.println("Item not found.");
        }
    }

    // Task 3 (YOU will implement menu)
    public static void main(String[] args) {

        // Parallel arrays
        String[] itemNames = new String[10];
        double[] itemPrices = new double[10];
        int[] itemStocks = new int[10];

        // Sample starter data
        itemNames[0] = "Milk";
        itemPrices[0] = 3.99;
        itemStocks[0] = 10;

        itemNames[1] = "Bread";
        itemPrices[1] = 2.49;
        itemStocks[1] = 20;

        itemNames[2] = "Eggs";
        itemPrices[2] = 4.99;
        itemStocks[2] = 15;

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("===== Grocery Menu =====");
            System.out.println("1. View Inventory");
            System.out.println("2. Restock Item");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                printInventory(itemNames, itemPrices, itemStocks);

            } else if (choice == 2) {
                System.out.print("Enter item name: ");
                String target = sc.nextLine();

                System.out.print("Enter amount to add: ");
                int amount = sc.nextInt();

                restockItem(itemNames, itemStocks, target, amount);

            } else if (choice == 3) {
                System.out.println("Goodbye!");
                break;

            } else {
                System.out.println("Invalid choice.\n");
            }
        }

        sc.close();
    }
}
