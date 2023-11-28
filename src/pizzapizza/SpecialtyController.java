package pizzapizza;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

/**
 * The `SpecialtyController` class is a controller for the specialty pizza selection
 * in the Pizza Pizza application. It implements the Initializable interface
 * to initialize the controller when the FXML file is loaded.
 *
 * @author Sibi suriyanarayan Tiruchirapalli venketaramani, Rahulraj Rajesh
 */
public class SpecialtyController implements Initializable {
    @FXML
    private ComboBox<String> combobox;

    @FXML
    private TextField totalprice;

    @FXML
    private CheckBox extracheese, extrasauce;

    @FXML
    private ListView<String> toppingslist;

    @FXML
    private ImageView deluxe, supreme, meatzza, seafood, pepperoni;

    @FXML
    private RadioButton small, medium, large;

    @FXML
    private Button addtoorder;

    /**
     * Hides all pizza images and displays the selected pizza image.
     */
    private void makeVisible(){
        deluxe.setVisible(false);
        supreme.setVisible(false);
        meatzza.setVisible(false);
        seafood.setVisible(false);
        pepperoni.setVisible(false);
        String image = combobox.getValue().toLowerCase();
        switch (image) {
            case "deluxe" -> deluxe.setVisible(true);
            case "supreme" -> supreme.setVisible(true);
            case "meatzza" -> meatzza.setVisible(true);
            case "seafood" -> seafood.setVisible(true);
            case "pepperoni" -> pepperoni.setVisible(true);
        }
    }

    /**
     * Retrieves the selected pizza size from the radio buttons.
     *
     * @return A String representing the selected pizza size.
     */
    private String getSize(){
        if(small.isSelected()){
            return "small";
        }else if(medium.isSelected()){
            return "medium";
        }
        return "large";
    }

    /**
     * Sets the total price based on the selected pizza and size,
     * considering additional options such as extra cheese and extra sauce.
     */
    @FXML
    private void setPrice(){
        if(addtoorder.isDisabled()) {
            addtoorder.setDisable(false);
            extracheese.setDisable(false);
            extrasauce.setDisable(false);
            small.setDisable(false);
            medium.setDisable(false);
            large.setDisable(false);
        }
        if(extracheese.isSelected() || extrasauce.isSelected()){
            extracheese.setSelected(false);
            extrasauce.setSelected(false);
        }
        String size = getSize();
        String pizza = combobox.getValue();
        double price = 0;
        if(pizza.equalsIgnoreCase("deluxe")){
            price = 14.99;
        }else if(pizza.equalsIgnoreCase("supreme")){
            price = 15.99;
        }else if(pizza.equalsIgnoreCase("meatzza")){
            price = 16.99;
        }else if(pizza.equalsIgnoreCase("seafood")){
            price = 17.99;
        }else if(pizza.equalsIgnoreCase("pepperoni")){
            price = 10.99;
        }
        if(size.equals("medium")) price += 2;
        else if(size.equals("large")) price += 4;
        DecimalFormat df = new DecimalFormat("#.00");
        totalprice.setText("$" + df.format(price));
    }

    /**
     * Adjusts the total price when the extra cheese checkbox is toggled.
     */
    @FXML
    private void check1(){
        double price;
        if(extracheese.isSelected()){
            price = Double.parseDouble(totalprice.getText().substring(Constants.one)) + Constants.one;
        }else{
            price = Double.parseDouble(totalprice.getText().substring(Constants.one)) - Constants.one;
        }
        DecimalFormat df = new DecimalFormat("#.00");
        totalprice.setText("$" + df.format(price));
    }

    /**
     * Adjusts the total price when the extra sauce checkbox is toggled.
     */
    @FXML
    private void check2(){
        double price;
        if(extrasauce.isSelected()){
            price = Double.parseDouble(totalprice.getText().substring(Constants.one)) + Constants.one;
        }else{
            price = Double.parseDouble(totalprice.getText().substring(Constants.one)) - Constants.one;
        }
        DecimalFormat df = new DecimalFormat("#.00");
        totalprice.setText("$" + df.format(price));
    }

    /**
     * Creates a pizza based on the selected options and adds it to the order.
     */
    @FXML
    private void makeZa(){
        Pizza pizza = PizzaMaker.createPizza(combobox.getValue().toLowerCase());
        if(getSize().equals("small")){
            pizza.setSize(Size.small);
        }else if(getSize().equals("medium")){
            pizza.setSize(Size.medium);
        }else if(getSize().equals("large")){
            pizza.setSize(Size.large);
        }
        pizza.setExtraCheese(extracheese.isSelected());
        pizza.setExtraSauce(extrasauce.isSelected());
        DataModel.getInstance().getOrder().getPizzaList().add(pizza);
    }

    /**
     * Initializes the controller, setting up the initial state of the UI elements.
     *
     * @param url            The location used to resolve relative paths for the root object.
     * @param resourceBundle The resources specific to this controller.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        combobox.setItems(FXCollections.observableArrayList("Deluxe", "Supreme", "Meatzza", "Seafood", "Pepperoni"));
        combobox.valueProperty().addListener((observableValue, s, selected) -> {
            if(selected.equals("Deluxe")){
                toppingslist.getItems().clear();
                toppingslist.getItems().add("Sausage");
                toppingslist.getItems().add("Pepperoni");
                toppingslist.getItems().add("Green Pepper");
                toppingslist.getItems().add("Onion");
                toppingslist.getItems().add("Mushroom");

            }else if(selected.equals("Supreme")){
                toppingslist.getItems().clear();
                toppingslist.getItems().add("Sausage");
                toppingslist.getItems().add("Pepperoni");
                toppingslist.getItems().add("Ham");
                toppingslist.getItems().add("Green Pepper");
                toppingslist.getItems().add("Onion");
                toppingslist.getItems().add("Black Olive");
                toppingslist.getItems().add("Mushroom");
            }else if(selected.equals("Meatzza")){
                toppingslist.getItems().clear();
                toppingslist.getItems().add("Sausage");
                toppingslist.getItems().add("Pepperoni");
                toppingslist.getItems().add("Beef");
                toppingslist.getItems().add("Ham");
            }else if(selected.equals("Seafood")){
                toppingslist.getItems().clear();
                toppingslist.getItems().add("Shrimp");
                toppingslist.getItems().add("Squid");
                toppingslist.getItems().add("Crab Meats");
            }else if(selected.equals("Pepperoni")){
                toppingslist.getItems().clear();
                toppingslist.getItems().add("Pepperoni");
            }
            setPrice();
            makeVisible();
        });
    }
}
