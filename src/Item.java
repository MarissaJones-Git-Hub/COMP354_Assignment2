/**
 * Generic Item object.
 */
public class Item {
    private final Restaurant restaurant;
    private final String name;
    private final String description;
    private final double price;

    public Item(Restaurant restaurant, String name, String description, double price) {
        if (restaurant == null) {
            throw new IllegalArgumentException("Item must belong to a restaurant.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Item name cannot be empty.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Item price cannot be negative.");
        }
        this.restaurant = restaurant;
        this.name = name.trim();
        this.description = description == null ? "" : description.trim();
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    @Override
    public String toString() {
        return String.format("%s - $%.2f (%s)", name, price, description);
    }
}