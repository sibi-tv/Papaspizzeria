package pizzapizza;

import java.util.ArrayList;

public class Pepperoni extends Pizza{
    public Pepperoni() {
        super();
        this.toppings = new ArrayList<>(){{add(Topping.pepperoni);}};
    }

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

    @Override
    public String getPizzaType() {
        return "Pepperoni";
    }
}
