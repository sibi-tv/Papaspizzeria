package pizzapizza;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Controller class for the "Build Pizza" view in the Pizza Pizza application.
 * Handles user interactions and updates the view based on the selected options.
 *
 * @author Sibi suriyanarayan Tiruchirapalli venketaramani, Rahulraj Rajesh
 */

public class BuildPizzaController implements Initializable {
    @FXML
    private ComboBox<String> sizecombobox;

    @FXML
    private ComboBox<String> toppingcombobox;

    @FXML
    private ListView<String> selectedTopping;

    @FXML
    private TextField tf;

    @FXML
    private Button add, orderAdd;

    @FXML
    private RadioButton tomato, alfredo;

    @FXML
    private CheckBox ExtraCheese, ExtraSauce;

    /**
     * Initializes the controller, setting up the initial state of the UI elements.
     *
     * @param url            The location used to resolve relative paths for the root object.
     * @param resourceBundle The resources specific to this controller.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> al = new ArrayList<>();
        for (Size siz : Size.values()) {al.add(siz.name());}
        sizecombobox.setItems(FXCollections.observableArrayList(al));
        sizecombobox.setValue(Size.small.name());
        al.clear();
        for (Topping top : Topping.values()) {al.add(top.name());}
        toppingcombobox.setItems(FXCollections.observableArrayList(al));
        tomato.setSelected(Constants.select);
        tf.setText(String.valueOf(Constants.byoSmallPrice));
    }

    /**
     * Adds the selected topping to the list of toppings and updates the UI elements.
     */
    @FXML
    void addTopping() {
        selectedTopping.getItems().add(toppingcombobox.getSelectionModel().getSelectedItem());
        if(selectedTopping.getItems().size() == Constants.maxToppings) {add.setDisable(Constants.disable);}
        if(selectedTopping.getItems().size() >= Constants.minToppings) {orderAdd.setDisable(!Constants.disable);}
        TotalPrice();
    }

    /**
     * Removes the selected topping from the list of toppings and updates the UI elements.
     */
    @FXML
    void removeTopping() {
        if(selectedTopping.getSelectionModel().getSelectedIndex() > -1){
            selectedTopping.getItems().remove(selectedTopping.getSelectionModel().getSelectedIndex());
            if (add.isDisabled()) {add.setDisable(!Constants.disable);}
            else if(selectedTopping.getItems().size() < Constants.minToppings) {orderAdd.setDisable(Constants.disable);}
            TotalPrice();
        }

    }

    /**
     * Handles the click event and updates the total price accordingly.
     */
    @FXML
    void clicked(){TotalPrice();}

    /**
     * Updates the total price based on the selected options.
     */
    @FXML
    void TotalPrice() {
        Pizza p = makeZa();
        Double price = p.price();
        tf.setText(price.toString());
    }

    /**
     * Creates a Pizza object based on the selected UI elements.
     *
     * @return A Pizza object with the selected options.
     */
    private Pizza makeZa() {
        Pizza p = PizzaMaker.createPizza("buildyourown");
        p.setSize(Size.valueOf(sizecombobox.getSelectionModel().getSelectedItem()));
        for (String i : selectedTopping.getItems()) {
            p.addToppings(Topping.valueOf(i));
        }
        p.setExtraCheese(ExtraCheese.isSelected());
        if (tomato.isSelected()) p.setSauce(Sauce.tomato);
        if (alfredo.isSelected()) p.setSauce(Sauce.alfredo);
        p.setExtraSauce(ExtraSauce.isSelected());
        return p;
    }

    /**
     * Adds the created pizza to the order and resets UI components to their default state.
     */
    @FXML
    public void addOrder() {
        DataModel.getInstance().getOrder().getPizzaList().add(makeZa());
        sizecombobox.setValue(Size.small.name());
        toppingcombobox.setValue(null);
        selectedTopping.getItems().clear();
        ExtraCheese.setSelected(!Constants.select);
        ExtraSauce.setSelected(!Constants.select);
        tomato.setSelected(Constants.select);
        alfredo.setSelected(!Constants.select);
        tf.setText(String.valueOf(Constants.byoSmallPrice));
        add.setDisable(!Constants.disable);
        orderAdd.setDisable(Constants.disable);
    }
}
