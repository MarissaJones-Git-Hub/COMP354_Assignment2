package src;

import java.util.*;

/**
 * Generic Restaurant object.
 */
public class Restaurant {
    private final String name;
    private final List<Item> menu = new ArrayList<>();

    public Restaurant(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Restaurant name cannot be empty.");
        }
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    public Item addItem(String itemName, String description, double price) {
        Item item = new Item(this, itemName, description, price);
        menu.add(item);
        return item;
    }

    public boolean removeItem(String itemName) {
        Item item = findItem(itemName);
        return item != null && menu.remove(item);
    }

    public Item findItem(String itemName) {
        if (itemName == null) return null;
        for (Item item : menu) {
            if (item.getName().equalsIgnoreCase(itemName.trim())) {
                return item;
            }
        }
        return null;
    }

    public List<Item> selectItem(Scanner scanner)
    {
        List<Item> itemsOrdered = new ArrayList<>();
        System.out.println("\n" + printMenu() + "\n");
        while (true) {
            System.out.print("Enter your choice (0 to Quit): ");

            if (!scanner.hasNextLine()) {
                return null;
            }

            String choice = scanner.nextLine().trim();

            int choiceNum;

            try {
                choiceNum = Integer.parseInt(choice);
            }
            catch (NumberFormatException e) {
                choiceNum = -1;
            }

            if (choiceNum == 0) {
                return itemsOrdered;
            }

            boolean addedItem = false;

            if (choiceNum > 0 && choiceNum <= menu.size()) {
                itemsOrdered.add(menu.get(choiceNum - 1));
                addedItem = true;
            }

            if (!addedItem) {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public List<Item> getMenu() {
        return Collections.unmodifiableList(menu);
    }

    public String printMenu() {
        StringBuilder menuString = new StringBuilder();
        List<Item> menu = getMenu();
        for (int i = 0; i < menu.size(); i++) {
            menuString.append("\n").append(i + 1).append(". ").append(menu.get(i));
        }
        return name + menuString;
    }

    @Override
    public String toString() {
        return name;
    }
}