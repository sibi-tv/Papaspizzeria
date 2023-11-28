package pizzapizza;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The Meatzza class represents a specific type of Pizza called Meatzza, which extends the Pizza class.
 * It includes a specific set of toppings and implements methods to calculate the price and get the pizza type.
 *
 * @author Sibi suriyanarayan Tiruchirapalli venketaramani, Rahulraj Rajesh
 */
public class Meatzza extends Pizza{

    /**
     * Constructs a Meatzza object with default values and initializes its toppings to a specific set.
     */
    public Meatzza() {
        super();
        this.toppings = new ArrayList<>(Arrays.asList(Topping.sausage, Topping.pepperoni, Topping.ham, Topping.beef));
    }

    /**
     * Calculates the price of the Meatzza based on its size and additional options such as extra cheese and sauce.
     *
     * @return The total price of the Meatzza.
     */
    @Override
    public double price() {
        double zaPrice;
        if (this.size == Size.small) zaPrice = Constants.meatzzaSmallPrice;
        else if (this.size == Size.medium) zaPrice = Constants.meatzzaSmallPrice + Constants.smallMed;
        else zaPrice = Constants.meatzzaSmallPrice + Constants.smallLarge;
        if (extraCheese) zaPrice += Constants.one;
        if (extraSauce) zaPrice += Constants.one;
        return zaPrice;
    }

    /**
     * Gets the type of the pizza, which is "Meatzza".
     *
     * @return The string representing the type of pizza, which is "Meatzza".
     */
    @Override
    public String getPizzaType() {
        return "Meatzza";
    }
}
