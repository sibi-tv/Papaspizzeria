package pizzapizza;

/**
 * The DataModel class represents a singleton data model for managing pizza orders and stored orders.
 *
 * @author Sibi suriyanarayan Tiruchirapalli venketaramani, Rahulraj Rajesh
 */

public class DataModel {
    /**
     * The single instance of the DataModel class.
     */
    private static final DataModel instance = new DataModel();
    /**
     * The current order being managed by the data model.
     */
    private Order order = new Order();
    /**
     * The collection of stored orders managed by the data model.
     */
    private StoredOrders so = new StoredOrders();

    /**
     * Private constructor to prevent external instantiation.
     */
    private DataModel() {}

    /**
     * Returns the single instance of the {@code DataModel} class.
     *
     * @return The {@code DataModel} instance.
     */
    public static DataModel getInstance() {
        return instance;
    }

    /**
     * Gets the current stored orders collection.
     *
     * @return The {@code StoredOrders} instance representing the stored orders.
     */
    public StoredOrders getStoredOrder() {
        return so;
    }

    /**
     * Sets the stored orders collection in the data model.
     *
     * @param so The {@code StoredOrders} instance to set.
     */
    public void setStoredOrder(StoredOrders so) {
        this.so = so;
    }

    /**
     * Gets the current order in the data model.
     *
     * @return The {@code Order} instance representing the current order.
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Sets the current order in the data model.
     *
     * @param order The {@code Order} instance to set.
     */
    public void setOrder(Order order) {
        this.order = order;
    }
}
