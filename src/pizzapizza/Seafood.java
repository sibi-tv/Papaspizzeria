package pizzapizza;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The Seafood class represents a pizza with seafood toppings, extending the Pizza class.
 * It includes a constructor to set default toppings and sauce, as well as methods to calculate
 * the price and retrieve the pizza type.
 *
 * @author Sibi suriyanarayan Tiruchirapalli venketaramani, Rahulraj Rajesh
 */
public class Seafood extends Pizza{

    /**
     * Constructs a Seafood pizza with default toppings (shrimp, squid, crab meat)
     * and Alfredo sauce. Sets the default size to small.
     */
    public Seafood() {
        super();
        this.toppings = new ArrayList<>(Arrays.asList(Topping.shrimp, Topping.squid, Topping.crabMeat));
        this.sauce = Sauce.alfredo;
    }

    /**
     * Calculates the price of the Seafood pizza based on its size and optional extras.
     * @return The total price of the Seafood pizza.
     */
    @Override
    public double price() {
        double zaPrice;
        if (this.size == Size.small) zaPrice = Constants.seafoodSmallPrice;
        else if (this.size == Size.medium) zaPrice = Constants.seafoodSmallPrice + Constants.smallMed;
        else zaPrice = Constants.seafoodSmallPrice + Constants.smallLarge;
        if (extraCheese) zaPrice += Constants.one;
        if (extraSauce) zaPrice += Constants.one;
        return zaPrice;
    }

    /**
     * Retrieves the type of pizza, which is "Seafood".
     * @return The type of pizza as a String.
     */
    @Override
    public String getPizzaType() {
        return "Seafood";
    }
}
