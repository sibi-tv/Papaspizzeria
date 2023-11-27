package pizzapizza;

import java.util.*;

public abstract class Pizza {
    protected ArrayList<Topping> toppings; // Topping is an enum
    protected Size size; // Size is an enum
    protected Sauce sauce; // Sauce is an enum
    protected boolean extraSauce;
    protected boolean extraCheese;

    public Pizza() {
        this.toppings = new ArrayList<>();
        this.size = Size.small;
        this.sauce = Sauce.tomato;
        this.extraSauce = false;
        this.extraCheese = false;
    }

    public ArrayList<Topping> getToppings() {return toppings;}
    public void addToppings(Topping t) {
        if (getPizzaType().equalsIgnoreCase("Build Your Own")){
            if (toppings.size() < Constants.maxToppings) {
                toppings.add(t);
            }
        }
    }

    public Size getSize() {return size;}
    public void setSize(Size size) {this.size = size;}

    public Sauce getSauce() {return sauce;}
    public void setSauce(Sauce sauce) {this.sauce = sauce;}

    public boolean isExtraSauce() {return extraSauce;}
    public void setExtraSauce(boolean extraSauce) {this.extraSauce = extraSauce;}

    public boolean isExtraCheese() {return extraCheese;}
    public void setExtraCheese(boolean extraCheese) {this.extraCheese = extraCheese;}

    public abstract double price(); // Polymorphism
    public abstract String getPizzaType();

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
