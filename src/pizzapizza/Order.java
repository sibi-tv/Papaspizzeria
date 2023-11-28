package pizzapizza;

import java.util.ArrayList;

/**
 * The Order class represents a pizza order containing a unique order number
 * and a list of pizzas to be included in the order.
 *
 * @author Sibi suriyanarayan Tiruchirapalli venketaramani, Rahulraj Rajesh
 */
public class Order {

    /**
     * The unique order number associated with this order.
     */
    private final int orderNum;

    /**
     * The list of pizzas included in this order.
     */
    private ArrayList<Pizza> pizzaList;

    /**
     * Constructs a new Order object with a unique order number and an empty
     * list of pizzas.
     */
    public Order() {
        this.orderNum = StoredOrders.getNextOrderNum();
        this.pizzaList = new ArrayList<>();
    }

    /**
     * Returns the unique order number of this order.
     *
     * @return the order number of this order.
     */
    public int getOrderNum() {return orderNum;}

    /**
     * Returns the list of pizzas included in this order.
     *
     * @return the list of pizzas in this order.
     */
    public ArrayList<Pizza> getPizzaList() {return pizzaList;}

    /**
     * Sets the list of pizzas for this order.
     *
     * @param pizzaList the list of pizzas to be set for this order.
     */
    public void setPizzaList(ArrayList<Pizza> pizzaList) {this.pizzaList = pizzaList;}

    /**
     * Returns the number of pizzas in this order.
     *
     * @return the number of pizzas in this order.
     */
    public int numPizzas() {return pizzaList.size();}

    /**
     * Adds a pizza to the list of pizzas in this order.
     *
     * @param pizza the pizza to be added to this order.
     */
    public void addPizza(Pizza pizza) {
        pizzaList.add(pizza);
    }

    /**
     * Removes a pizza from the list of pizzas in this order.
     *
     * @param pizza the pizza to be removed from this order.
     */
    public void removePizza(Pizza pizza){ pizzaList.remove(pizza); }

}
