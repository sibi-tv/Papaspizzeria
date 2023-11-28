package pizzapizza;

/**
 * The Topping enum represents various pizza toppings that can be used in a pizza order.
 * Each topping has a corresponding name.
 *
 * @author Sibi suriyanarayan Tiruchirapalli venketaramani, Rahulraj Rajesh
 */
public enum Topping {
    /**
     * Represents the sausage topping.
     */
    sausage("Sausage"),
    /**
     * Represents the pepperoni topping.
     */
    pepperoni("Pepperoni"),
    /**
     * Represents the green pepper topping.
     */
    greenPepper("Green Pepper"),
    /**
     * Represents the onion topping.
     */
    onion("Onion"),
    /**
     * Represents the mushroom topping.
     */
    mushroom("Mushroom"),
    /**
     * Represents the ham topping.
     */
    ham("Ham"),
    /**
     * Represents the black olive topping.
     */
    blackOlive("Black Olive"),
    /**
     * Represents the beef topping.
     */
    beef("Beef"),
    /**
     * Represents the shrimp topping.
     */
    shrimp("Shrimp"),
    /**
     * Represents the squid topping.
     */
    squid("Squid"),
    /**
     * Represents the crab meat topping.
     */
    crabMeat("Crab Meats"),
    /**
     * Represents the pineapple topping.
     */
    pineapple("Pineapple"),
    /**
     * Represents the chicken topping.
     */
    chicken("Chicken");

    /**
     * The name of the topping.
     */
    private String topping;

    /**
     * Constructs a new {@code Topping} with the specified name.
     *
     * @param topping The name of the topping.
     */
    Topping(String topping) { this.topping = topping;}
}
