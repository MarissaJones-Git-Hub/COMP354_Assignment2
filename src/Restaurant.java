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