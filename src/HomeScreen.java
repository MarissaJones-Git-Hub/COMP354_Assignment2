import java.util.Scanner;

public class HomeScreen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            showHomeScreen();

            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                showRestaurantDisplay();
            } else if (choice.equals("0")) {
                System.out.println("Thanks for using QuickBite.");
                running = false;
            } else {
                System.out.println("Please enter 1 or 0.");
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void showHomeScreen() {
        System.out.println();
        System.out.println("Welcome to QuickBite!!!");
        System.out.println("Fresh meals, fast pickup!");
        System.out.println();
        System.out.println("1. View Restaurants");
        System.out.println("0. Exit");
        System.out.println();
    }

    private static void showRestaurantDisplay() {
        System.out.println();
        System.out.println("Restaurant Display");
        System.out.println("The restaurant list will be connected during integration.");
    }
}
