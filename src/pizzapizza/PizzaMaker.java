package pizzapizza;

/**
 * The `PizzaMaker` class provides a simple factory method to create various types of pizzas.
 * It includes a static method, `createPizza`, that takes a String parameter representing the
 * type of pizza to be created and returns an instance of the corresponding pizza class.
 *
 * @author Sibi suriyanarayan Tiruchirapalli venketaramani, Rahulraj Rajesh
 */
public class PizzaMaker {
    /**
     * Creates a pizza object based on the specified pizza type.
     *
     * @param pizzaType A String specifying the type of pizza to be created.
     *                  Valid values are "deluxe," "supreme," "meatzza," "seafood,"
     *                  "pepperoni," and "buildyourown."
     * @return An instance of the corresponding pizza class based on the provided pizza type.
     *         Returns null if the pizza type is not recognized.
     */
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

