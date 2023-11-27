package pizzapizza;

public class DataModel {
    private static final DataModel instance = new DataModel();
    private Order order = new Order();
//    private StoredOrders so...

    private DataModel() {
        // Private constructor to enforce singleton pattern
    }

    public static DataModel getInstance() {
        return instance;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
