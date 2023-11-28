package pizzapizza;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The Supreme class represents a pizza of the "Supreme" variety, which extends the {@code Pizza} class.
 * It includes specific toppings and defines methods for calculating the price and retrieving the pizza type.
 *
 * @author Sibi suriyanarayan Tiruchirapalli venketaramani, Rahulraj Rajesh
 */
public class Supreme extends Pizza{

    /**
     * Constructs a new instance of the {@code Supreme} class, initializing its toppings with a predefined set.
     */
    public Supreme() {
        super();
        this.toppings = new ArrayList<>(Arrays.asList(Topping.sausage, Topping.pepperoni, Topping.ham, Topping.greenPepper,
                Topping.onion, Topping.blackOlive, Topping.mushroom));
    }

    /**
     * Calculates the price of the Supreme pizza based on its size, additional toppings, and extra options.
     *
     * @return The total price of the Supreme pizza.
     */
    @Override
    public double price() {
        double zaPrice;
        if (this.size == Size.small) zaPrice = Constants.supremeSmallPrice;
        else if (this.size == Size.medium) zaPrice = Constants.supremeSmallPrice + Constants.smallMed;
        else zaPrice = Constants.supremeSmallPrice + Constants.smallLarge;
        if (extraCheese) zaPrice += Constants.one;
        if (extraSauce) zaPrice += Constants.one;
        return zaPrice;
    }

    /**
     * Retrieves the type of the pizza, which is "Supreme".
     *
     * @return A {@code String} representing the type of the pizza.
     */
    @Override
    public String getPizzaType() {
        return "Supreme";
    }
}
