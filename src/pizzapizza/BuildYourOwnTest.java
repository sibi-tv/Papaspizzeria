package pizzapizza;

import static org.junit.Assert.*;


public class BuildYourOwnTest {

    @org.junit.Test
    public void testValidSmallDeluxePizza() {
        Pizza p = PizzaMaker.createPizza("deluxe");
        p.setSize(Size.small);

        assertTrue(p.price() == 14.99);
    }

    @org.junit.Test
    public void testPizzaWithExtraCheese() {
        Pizza p = PizzaMaker.createPizza("deluxe");
        p.setSize(Size.small);
        p.setExtraCheese(true);

        assertTrue(p.price() == 15.99);
    }
}