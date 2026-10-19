package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RestaurantDisplay {

    private List<Restaurant> restaurants = new ArrayList<Restaurant>();

    public RestaurantDisplay()
    {
        Restaurant restaurant1 = new Restaurant("Pizza Pizza");
        Restaurant restaurant2 = new Restaurant("Burger King");
        Restaurant restaurant3 = new Restaurant("Sushi Spot");

        restaurant1.addItem("Small Pepperoni Pizza", "Pepperoni, homestyle sauce, and mozzarella", 10.25);
        restaurant1.addItem("Medium Classic Super Pizza", "Pepperoni, fresh mushrooms, green peppers, and mozzarella cheese", 16.49);
        restaurant1.addItem("Large Meat Supreme Pizza", "Pepperoni, bacon crumble, salami, spicy Italian sausage, mozzarella cheese, and Italiano blend seasoning", 22.79);

        restaurant2.addItem("Whopper", "The Whopper® is a ¼ lb of flame-grilled beef topped with hand-cut juicy tomatoes, fresh cut lettuce, creamy mayonnaise, ketchup, crunchy pickles, and sliced white onions on a new, fluffier sesame seed bun", 7.99);
        restaurant2.addItem("Chicken Nuggets", "Made with white meat, Canadian chicken and coated in a crispy tempura-style batter, the new Chicken Nuggets have a crunchy bite and juicy, flavourful centre", 4.99);
        restaurant2.addItem("Medium Fries", "Thin-cut, skin-on fries coated with a new crispier batter and made with potatoes from local Canadian farms", 4.19);

        restaurant3.addItem("Edamame", "Baby soybeans steamed in the pod, salted and served hot", 6);
        restaurant3.addItem("Chirashi~Don", "Scattered sashimi served over sushi rice", 27);
        restaurant3.addItem("Smoked Salmon", "Inside out roll with avocado or cream cheese, sesame seeds and green onions", 11);

        restaurants.add(restaurant1);
        restaurants.add(restaurant2);
        restaurants.add(restaurant3);
    }

    public void displayRestaurants() {
        System.out.println("\nAvailable Restaurants");
        System.out.println("---------------------");

        for (int i = 0; i < restaurants.size(); i++) {
            System.out.println((i + 1) + ". " + restaurants.get(i));
        }

        System.out.println("0. Back");
    }

    public Restaurant selectRestaurant(Scanner scanner) {
        displayRestaurants();
        System.out.println();
        while (true) {
            System.out.print("Enter your choice (0 to Quit): ");

            if (!scanner.hasNextLine()) {
                return null;
            }

            String choice = scanner.nextLine().trim();

            if (choice.equals("0")) {
                return null;
            }

            for (int i = 0; i < restaurants.size(); i++) {
                String number = String.valueOf(i + 1);

                if (choice.equals(number)) {
                    return restaurants.get(i);
                }
            }

            System.out.println("Invalid choice. Please try again.");
        }
    }
}
