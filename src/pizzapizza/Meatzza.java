package pizzapizza;

import java.util.ArrayList;
import java.util.Arrays;

public class Meatzza extends Pizza{

    public Meatzza() {
        super();
        this.toppings = new ArrayList<>(Arrays.asList(Topping.sausage, Topping.pepperoni, Topping.ham, Topping.beef));
    }

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

    @Override
    public String getPizzaType() {
        return "Meatzza";
    }
}
