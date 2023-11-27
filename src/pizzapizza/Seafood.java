package pizzapizza;

import java.util.ArrayList;
import java.util.Arrays;

public class Seafood extends Pizza{

    public Seafood() {
        super();
        this.toppings = new ArrayList<>(Arrays.asList(Topping.shrimp, Topping.squid, Topping.crabMeat));
        this.sauce = Sauce.alfredo;
    }

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

    @Override
    public String getPizzaType() {
        return "Seafood";
    }
}
