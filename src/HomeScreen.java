package src;

import java.util.List;
import java.util.Scanner;

public class HomeScreen {

    public static Scanner scanner = new Scanner(System.in);
    public static RestaurantDisplay restaurantDisplay = new RestaurantDisplay();
    public static Order order = new Order();

    public static void main(String[] args) {
        System.out.println();
        boolean running = true;

        while (running) {
            showHomeScreen();

            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch(choice) {
                case "1":
                    showRestaurantDisplay();
                    break;
                case "2":
                    order.ViewOrder();
                    break;
                case "0":
                    System.out.print("Thanks for using QuickBite.");
                    running = false;
                    break;
                default:
                    System.out.println("Please enter 1 or 0.");
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void showHomeScreen() {
        System.out.println("Welcome to QuickBite!!!");
        System.out.println("Fresh meals, fast pickup!");
        System.out.println();
        System.out.println("1. View Restaurants");
        System.out.println("2. View Order");
        System.out.println("0. Exit");
        System.out.println();
    }

    private static void showRestaurantDisplay() {
        System.out.println();
        System.out.println("Restaurant Display");

        Restaurant selected = restaurantDisplay.selectRestaurant(scanner);

        if(selected == null)
        {
            return;
        }

        List<Item> items = selected.selectItem(scanner);

        if(items == null || items.isEmpty())
        {
            return;
        }

        order.AddItemsToOrder(items);
    }
}
