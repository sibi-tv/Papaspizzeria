package pizzapizza;

import java.util.*;

/**
 * The abstract base class for Pizza in the PizzaPizza application.
 * It includes properties such as toppings, size, sauce, and options for extra sauce and extra cheese.
 *
 * @author Sibi suriyanarayan Tiruchirapalli venketaramani, Rahulraj Rajesh
 */
public abstract class Pizza {
    /**
     * The list of toppings for the pizza.
     */
    protected ArrayList<Topping> toppings; // Topping is an enum
    /**
     * The size of the pizza.
     */
    protected Size size; // Size is an enum
    /**
     * The type of sauce on the pizza.
     */
    protected Sauce sauce; // Sauce is an enum
    /**
     * Indicates whether extra sauce is requested for the pizza.
     */
    protected boolean extraSauce;
    /**
     * Indicates whether extra cheese is requested for the pizza.
     */
    protected boolean extraCheese;

    /**
     * Constructs a default pizza with initial values.
     */
    public Pizza() {
        this.toppings = new ArrayList<>();
        this.size = Size.small;
        this.sauce = Sauce.tomato;
        this.extraSauce = false;
        this.extraCheese = false;
    }

    /**
     * Gets the list of toppings on the pizza.
     *
     * @return An ArrayList containing the toppings.
     */
    public ArrayList<Topping> getToppings() {return toppings;}

    /**
     * Adds a topping to the pizza if it is a "BuildYourOwn" type and the maximum number of toppings has not been reached.
     *
     * @param t The topping to be added.
     */
    public void addToppings(Topping t) {
        if (getPizzaType().equalsIgnoreCase("BuildYourOwn")){
            if (toppings.size() < Constants.maxToppings) {
                toppings.add(t);
            }
        }
    }

    /**
     * Gets the size of the pizza.
     *
     * @return The size of the pizza.
     */
    public Size getSize() {return size;}
    /**
     * Sets the size of the pizza.
     *
     * @param size The new size of the pizza.
     */
    public void setSize(Size size) {this.size = size;}

    /**
     * Gets the sauce on the pizza.
     *
     * @return The sauce on the pizza.
     */
    public Sauce getSauce() {return sauce;}
    /**
     * Sets the sauce for the pizza.
     *
     * @param sauce The new sauce for the pizza.
     */
    public void setSauce(Sauce sauce) {this.sauce = sauce;}

    /**
     * Checks if extra sauce is requested for the pizza.
     *
     * @return true if extra sauce is requested, false otherwise.
     */
    public boolean isExtraSauce() {return extraSauce;}
    /**
     * Sets whether extra sauce is requested for the pizza.
     *
     * @param extraSauce true if extra sauce is requested, false otherwise.
     */
    public void setExtraSauce(boolean extraSauce) {this.extraSauce = extraSauce;}

    /**
     * Checks if extra cheese is requested for the pizza.
     *
     * @return true if extra cheese is requested, false otherwise.
     */
    public boolean isExtraCheese() {return extraCheese;}
    /**
     * Sets whether extra cheese is requested for the pizza.
     *
     * @param extraCheese true if extra cheese is requested, false otherwise.
     */
    public void setExtraCheese(boolean extraCheese) {this.extraCheese = extraCheese;}

    /**
     * Abstract method to calculate the price of the pizza.
     *
     * @return The price of the pizza.
     */
    public abstract double price();
    /**
     * Abstract method to get the type of the pizza.
     *
     * @return The type of the pizza.
     */
    public abstract String getPizzaType();

    /**
     * Returns a string representation of the pizza, including its type, toppings, size, sauce, and optional extras.
     *
     * @return A formatted string representing the pizza.
     */
    @Override
    public String toString() {
        StringBuilder pizzaString = new StringBuilder("[" + getPizzaType() + "], ");
        for (Topping top : toppings) {
            pizzaString.append(top.name()).append(", ");
        }
        pizzaString.append(size.name()).append(", ");
        pizzaString.append(sauce.name()).append(", ");
        if (extraSauce) pizzaString.append("extra sauce, ");
        if (extraCheese) pizzaString.append("extra cheese ");
        pizzaString.append("$").append(price());
        return pizzaString.toString();
    }
}
