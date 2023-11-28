package pizzapizza;

public class DataModel {
    private static final DataModel instance = new DataModel();
    private Order order = new Order();
    private StoredOrders so = new StoredOrders();

    private DataModel() {

    }

    public static DataModel getInstance() {
        return instance;
    }

    public StoredOrders getStoredOrder() {
        return so;
    }

    public void setStoredOrder(StoredOrders so) {
        this.so = so;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
