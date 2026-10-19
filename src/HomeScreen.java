import java.util.Scanner;

public class HomeScreen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            displayHomeScreen();

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    showRestaurantDisplay();
                    break;

                case "0":
                    System.out.println("\nThank you for using QuickBite!");
                    running = false;
                    break;

                default:
                    System.out.println("\nInvalid option. Please try again.\n");
            }
        }

        scanner.close();
    }

    private static void displayHomeScreen() {
        System.out.println("==========================================");
        System.out.println("                 QUICKBITE                ");
        System.out.println("==========================================");
        System.out.println("        Fresh meals, fast pickup.");
        System.out.println();
        System.out.println("Order from local restaurants and");
        System.out.println("pick up your meal.");
        System.out.println();
        System.out.println("1. View Restaurants");
        System.out.println("0. Exit");
        System.out.println("==========================================");
    }

    private static void showRestaurantDisplay() {
        System.out.println("\n==========================================");
        System.out.println("            RESTAURANT DISPLAY            ");
        System.out.println("==========================================");
        System.out.println("Restaurant display will be connected");
        System.out.println("during feature integration.");
        System.out.println("==========================================\n");
    }
}
