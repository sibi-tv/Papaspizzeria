package pizzapizza;

import java.util.ArrayList;

/**
 * The Pepperoni class represents a pizza with pepperoni as its topping.
 * It extends the Pizza class and provides specific implementations for pricing
 * and retrieving the pizza type.
 *
 * @author Sibi suriyanarayan Tiruchirapalli venketaramani, Rahulraj Rajesh
 */
public class Pepperoni extends Pizza{
    /**
     * Constructs a Pepperoni pizza with default values.
     * Sets the toppings to include only pepperoni.
     */
    public Pepperoni() {
        super();
        this.toppings = new ArrayList<>(){{add(Topping.pepperoni);}};
    }

    /**
     * Calculates and returns the price of the Pepperoni pizza based on its size
     * and optional extras such as extra cheese and sauce.
     *
     * @return The total price of the Pepperoni pizza.
     */
    @Override
    public double price() {
        double zaPrice;
        if (this.size == Size.small) zaPrice = Constants.pepperoniSmallPrice;
        else if (this.size == Size.medium) zaPrice = Constants.pepperoniSmallPrice + Constants.smallMed;
        else zaPrice = Constants.pepperoniSmallPrice + Constants.smallLarge;
        if (extraCheese) zaPrice += Constants.one;
        if (extraSauce) zaPrice += Constants.one;
        return zaPrice;
    }

    /**
     * Retrieves the type of pizza, which is "Pepperoni" for this class.
     *
     * @return A String representing the type of pizza.
     */
    @Override
    public String getPizzaType() {
        return "Pepperoni";
    }
}
