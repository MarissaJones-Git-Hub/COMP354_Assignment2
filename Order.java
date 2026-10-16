import java.util.*;

public class Order
{
    ArrayList<Item> order = new ArrayList<>();

    public void AddItemToOrder(Item item)
    {
        order.add(item);
    }

    public void RemoveItemFromOrder(Item item)
    {
        order.remove(item);
    }

    public void PrintOrder()
    {
        System.out.println("Order\n-----");
        for (Item item : order)
        {
            item.PrintItem();
        }
    }

    public void ViewOrder()
    {
        Scanner scanner = new Scanner(System.in);
        String input;

        boolean quit = false;

        do
        {
            PrintOrder();

            System.out.print("\nSelect Item to Remove (Q to Quit): ");

            input = scanner.nextLine();

            if(input.equalsIgnoreCase("Q"))
            {
                quit = true;
            }

            boolean removedItem = false;

            for (Item item : order)
            {
                if(item.name.equals(input))
                {
                    RemoveItemFromOrder(item);
                    removedItem = true;
                    System.out.println("\nRemoved " + item.name + " from order\n");
                    break;
                }
            }

            if(!quit && !removedItem)
            {
                System.out.println("\nItem not found\n");
            }

        }while(!quit);
    }
}
