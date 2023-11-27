package pizzapizza;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class StoredOrders {
    private static ArrayList<Order> orderList;
    private static int orderNum;

    public StoredOrders() {
        orderList = new ArrayList<>();
        orderNum = Constants.none;
    }
    //never use this outside of a constructor for a normal order object
    public static int getNextOrderNum() {
        return ++orderNum;
    }
    public void addOrder(Order order) { orderList.add(order); }

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
