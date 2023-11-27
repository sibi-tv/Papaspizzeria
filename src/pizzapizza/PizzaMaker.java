package pizzapizza;

public class PizzaMaker {
    public static Pizza createPizza(String pizzaType) {
        if (pizzaType.equalsIgnoreCase("deluxe")) return new Deluxe();
        else if (pizzaType.equalsIgnoreCase("supreme")) return new Supreme();
        else if (pizzaType.equalsIgnoreCase("meatzza")) return new Meatzza();
        else if (pizzaType.equalsIgnoreCase("seafood")) return new Seafood();
        else if (pizzaType.equalsIgnoreCase("pepperoni")) return new Pepperoni();
        else if (pizzaType.equalsIgnoreCase("buildyourown")) return new BuildYourOwn();
        else return null;
    }
}

