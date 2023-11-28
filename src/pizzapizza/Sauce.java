package pizzapizza;

/**
 * The Sauce enum represents different types of pizza sauces.
 * It includes options for Tomato and Alfredo sauces.
 *
 * @author Sibi suriyanarayan Tiruchirapalli venketaramani, Rahulraj Rajesh
 */
public enum Sauce {
    /**
     * Represents Tomato sauce for the pizza.
     */
    tomato("Tomato"),
    /**
     * Represents Alfredo sauce for the pizza.
     */
    alfredo("Alfredo");

    /**
     * Represents the selected sauce for the pizza.
     */
    private String sauce;

    /**
     * Constructs a Sauce enum with the specified sauce name.
     *
     * @param sauce The name of the sauce.
     */
    Sauce(String sauce) { this.sauce = sauce;}
}
