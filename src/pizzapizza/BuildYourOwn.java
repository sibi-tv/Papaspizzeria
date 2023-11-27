package pizzapizza;

public class BuildYourOwn extends Pizza{
    public BuildYourOwn() {
        super(); // Initializes with no toppings + no sauce
    }

    @Override
    public double price() {
        double zaPrice;
        if (this.size == Size.small) zaPrice = Constants.byoSmallPrice + (Constants.top*(toppings.size()-Constants.three));
        else if (this.size == Size.medium) zaPrice = Constants.byoSmallPrice + Constants.smallMed +
                (Constants.top*(toppings.size()-Constants.three));
        else zaPrice = Constants.byoSmallPrice + Constants.smallLarge + (Constants.top*(toppings.size()-Constants.three));
        if (extraCheese) zaPrice += Constants.one;
        if (extraSauce) zaPrice += Constants.one;
        return zaPrice;
    }

    @Override
    public String getPizzaType() {
        return "BuildYourOwn";
    }
}
