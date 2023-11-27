package pizzapizza;

import java.util.ArrayList;
import java.util.Arrays;

public class Supreme extends Pizza{

    public Supreme() {
        super();
        this.toppings = new ArrayList<>(Arrays.asList(Topping.sausage, Topping.pepperoni, Topping.ham, Topping.greenPepper,
                Topping.onion, Topping.blackOlive, Topping.mushroom));
    }

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

    @Override
    public String getPizzaType() {
        return "Supreme";
    }
}
