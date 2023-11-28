package pizzapizza;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * The `StoredOrders` class manages the storage and retrieval of pizza orders.
 * It provides methods to add orders, retrieve the order list, and export orders to a file.
 *
 * @author Sibi suriyanarayan Tiruchirapalli venketaramani, Rahulraj Rajesh
 */
public class StoredOrders {
    /**
     * The list of stored orders.
     */
    private static ArrayList<Order> orderList;
    /**
     * The current order number.
     */
    private static int orderNum;

    /**
     * Constructs a new `StoredOrders` object with an empty order list and initializes the order number.
     */
    public StoredOrders() {
        orderList = new ArrayList<Order>();
        orderNum = Constants.one;
    }

    /**
     * Retrieves the next order number.
     *
     * @return The next order number.
     * @apiNote This method should only be used within a constructor for a normal order object.
     */
    public static int getNextOrderNum() {
        return ++orderNum;
    }
    /**
     * Adds a new order to the list of stored orders.
     *
     * @param order The order to be added.
     */
    public void addOrder(Order order) { orderList.add(order); }

    /**
     * Retrieves the list of stored orders.
     *
     * @return The list of stored orders.
     */
    public ArrayList<Order> getOrderList(){ return orderList; }

    /**
     * Exports the stored orders to a file named "Order.dat".
     * Uses `ObjectOutputStream` for serialization.
     *
     * @apiNote This method may be subject to change, especially for implementing a file chooser.
     */
    public static void export() { // Change everything about this probably FileChooser
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Order.dat"));) {
            for (Order item : orderList) {
                output.writeChars(item.toString());
            }
            System.out.println("Export to file successful.");
        } catch (IOException e) {
            System.err.println("Error exporting to file: " + e.getMessage());
        }
    }
}
