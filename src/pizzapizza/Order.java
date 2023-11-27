package pizzapizza;

import java.util.ArrayList;

public class Order {

    private final int orderNum;
    public ArrayList<Pizza> pizzaList;

    public Order() {
        this.orderNum = StoredOrders.getNextOrderNum();
        this.pizzaList = new ArrayList<>();
    }

    public int getOrderNum() {return orderNum;}

    public ArrayList<Pizza> getPizzaList() {return pizzaList;}
    public void setPizzaList(ArrayList<Pizza> pizzaList) {this.pizzaList = pizzaList;}
    public int numPizzas() {return pizzaList.size();}

    public void addPizza(Pizza pizza) {
        pizzaList.add(pizza);
    }
    public void removePizza(Pizza pizza){ pizzaList.remove(pizza); }

}
