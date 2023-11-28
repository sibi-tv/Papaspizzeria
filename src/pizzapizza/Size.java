package pizzapizza;

/**
 * The Size enum representing different sizes for a pizza.
 *
 * @author Sibi suriyanarayan Tiruchirapalli venketaramani, Rahulraj Rajesh
 */
public enum Size {
    /**
     * Represents a small-sized pizza.
     */
    small("Small"),
    /**
     * Represents a medium-sized pizza.
     */
    medium("Medium"),
    /**
     * Represents a large-sized pizza.
     */
    large("Large");

    /**
     * Represents the selected size for the pizza.
     */
    private String size;

    /**
     * Constructs a Size enum with the specified size label.
     *
     * @param size The label representing the size of the pizza.
     */
    Size(String size) { this.size = size; }
}
