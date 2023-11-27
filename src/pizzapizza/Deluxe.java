package pizzapizza;

import java.util.ArrayList;
import java.util.Arrays;

public class Deluxe extends Pizza {

    public Deluxe() {
        super();
        this.toppings = new ArrayList<>(Arrays.asList(Topping.sausage, Topping.pepperoni, Topping.greenPepper, Topping.onion,
                Topping.mushroom));
    }

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

    @Override
    public String getPizzaType() {
        return "Deluxe";
    }
}
