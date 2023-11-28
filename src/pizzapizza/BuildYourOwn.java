package pizzapizza;

/**
 * The BuildYourOwn class represents a customizable pizza where customers can build their own pizza
 * by selecting toppings and adjusting the size. It extends the Pizza class and provides
 * functionality to calculate the price and retrieve the pizza type.
 *
 * @author Sibi suriyanarayan Tiruchirapalli venketaramani, Rahulraj Rajesh
 */

public class BuildYourOwn extends Pizza{
    /**
     * Constructs a new {@code BuildYourOwn} pizza object. Initializes the pizza with no toppings and no sauce.
     */
    public BuildYourOwn() {
        super(); // Initializes with no toppings + no sauce
    }

    /**
     * Calculates the price of the BuildYourOwn pizza based on the number of toppings, size, and additional options
     * such as extra cheese and sauce.
     *
     * @return The total price of the BuildYourOwn pizza.
     */
    @Override
    public double price() {
        if (toppings.size() < Constants.three) {
            return Constants.byoSmallPrice;
        } else {
            double zaPrice;
            if (this.size == Size.small) zaPrice = Constants.byoSmallPrice + (Constants.top*(toppings.size()-Constants.three));
            else if (this.size == Size.medium) zaPrice = Constants.byoSmallPrice + Constants.smallMed +
                    (Constants.top*(toppings.size()-Constants.three));
            else zaPrice = Constants.byoSmallPrice + Constants.smallLarge + (Constants.top*(toppings.size()-Constants.three));
            if (extraCheese) zaPrice += Constants.one;
            if (extraSauce) zaPrice += Constants.one;
            return zaPrice;
        }
    }

    /**
     * Retrieves the type of the pizza, which is "BuildYourOwn".
     *
     * @return The pizza type as a String.
     */
    @Override
    public String getPizzaType() {
        return "BuildYourOwn";
    }
}
