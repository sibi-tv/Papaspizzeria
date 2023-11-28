package pizzapizza;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The Deluxe class represents a pizza with a combination of various toppings.
 * It extends the Pizza class and provides specific implementations for pricing
 * and retrieving the pizza type.
 *
 * @author Sibi suriyanarayan Tiruchirapalli venketaramani, Rahulraj Rajesh
 */

public class Deluxe extends Pizza {

    /**
     * Constructs a Deluxe pizza with default size and a predefined set of toppings.
     * Toppings include sausage, pepperoni, green pepper, onion, and mushroom.
     */
    public Deluxe() {
        super();
        this.toppings = new ArrayList<>(Arrays.asList(Topping.sausage, Topping.pepperoni, Topping.greenPepper, Topping.onion,
                Topping.mushroom));
    }

    /**
     * Calculates the price of the Deluxe pizza based on its size and additional options.
     * The price is determined by Constants.deluxeSmallPrice for small size,
     * and additional charges for medium and large sizes.
     * Extra cheese and extra sauce options incur additional charges as well.
     *
     * @return The calculated price of the Deluxe pizza.
     */
    @Override
    public double price() {
        double zaPrice;
        if (this.size == Size.small) zaPrice = Constants.deluxeSmallPrice;
        else if (this.size == Size.medium) zaPrice = Constants.deluxeSmallPrice + Constants.smallMed;
        else zaPrice = Constants.deluxeSmallPrice + Constants.smallLarge;
        if (extraCheese) zaPrice += Constants.one;
        if (extraSauce) zaPrice += Constants.one;
        return zaPrice;
    }

    /**
     * Retrieves the type of pizza, which is "Deluxe" for objects of the Deluxe class.
     *
     * @return The type of pizza, which is "Deluxe".
     */
    @Override
    public String getPizzaType() {
        return "Deluxe";
    }
}
