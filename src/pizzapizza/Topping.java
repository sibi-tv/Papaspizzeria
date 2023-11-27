package pizzapizza;

public enum Topping {
    sausage("Sausage"),
    pepperoni("Pepperoni"),
    greenPepper("Green Pepper"),
    onion("Onion"),
    mushroom("Mushroom"),
    ham("Ham"),
    blackOlive("Black Olive"),
    beef("Beef"),
    shrimp("Shrimp"),
    squid("Squid"),
    crabMeat("Crab Meats"),
    pineapple("Pineapple"),
    chicken("Chicken");

    private String topping;

    Topping(String topping) { this.topping = topping;}
}
