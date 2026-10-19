import java.util.Scanner;

public class RestaurantDisplay {

    private final String[] restaurants = {
        "Pizza Pizza",
        "Burger King",
        "Sushi Spot"
    };

    public void displayRestaurants() {
        System.out.println("\nAvailable Restaurants");
        System.out.println("---------------------");

        for (int i = 0; i < restaurants.length; i++) {
            System.out.println((i + 1) + ". " + restaurants[i]);
        }

        System.out.println("0. Back");
    }

    public String selectRestaurant(Scanner scanner) {
        while (true) {
            displayRestaurants();
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextLine()) {
                return null;
            }

            String choice = scanner.nextLine().trim();

            if (choice.equals("0")) {
                return null;
            }

            for (int i = 0; i < restaurants.length; i++) {
                String number = String.valueOf(i + 1);

                if (choice.equals(number)) {
                    return restaurants[i];
                }
            }

            System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RestaurantDisplay display = new RestaurantDisplay();

        String selected = display.selectRestaurant(scanner);

        if (selected != null) {
            System.out.println("You selected: " + selected);
        } else {
            System.out.println("Going back.");
        }
    }
}
