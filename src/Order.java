package src;

import java.util.*;

public class Order
{
    private List<Item> order = new ArrayList<>();

    public void AddItemsToOrder(List<Item> items)
    {
        for (int i = 0; i < items.size(); i++)
        {
            AddItemToOrder(items.get(i));
        }
    }

    public void AddItemToOrder(Item item)
    {
        order.add(item);
    }

    public void RemoveItemsFromOrder(List<Item> items)
    {
        for (int i = 0; i < items.size(); i++)
        {
            RemoveItemFromOrder(items.get(i));
        }
    }

    public void RemoveItemFromOrder(Item item)
    {
        order.remove(item);
    }

    public void PrintOrder()
    {
        System.out.println("\nOrder\n-----");
        for (int i = 0; i < order.size(); i++)
        {
            System.out.println((i + 1) + ". " + order.get(i).toString());
        }

        System.out.println();
    }

    public void ViewOrder()
    {
        Scanner scanner = new Scanner(System.in);
        String input;

        List<Item> itemsRemoved = new ArrayList<>();
        PrintOrder();

        while(true)
        {
            System.out.print("Select Item to Remove (0 to Quit): ");

            input = scanner.nextLine();

            int inputNum;

            try
            {
                inputNum = Integer.parseInt(input);
            }
            catch (NumberFormatException e)
            {
                inputNum = -1;
            }

            if(inputNum == 0)
            {
                break;
            }

            boolean removedItem = false;

            if(inputNum > 0 &&  inputNum <= order.size())
            {
                if(itemsRemoved.contains(order.get(inputNum - 1)))
                {
                    System.out.println("Item already removed from order");
                }
                else
                {
                    itemsRemoved.add(order.get(inputNum - 1));
                }

                removedItem = true;
            }

            if(!removedItem)
            {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        RemoveItemsFromOrder(itemsRemoved);
    }
}
