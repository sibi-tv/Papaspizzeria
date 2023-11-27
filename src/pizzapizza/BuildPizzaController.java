package pizzapizza;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BuildPizzaController implements Initializable {
    @FXML
    ComboBox<String> sizecombobox;

    @FXML
    ComboBox<String> toppingcombobox;

    @FXML
    ListView<String> selectedTopping;

    @FXML
    TextField tf;

    @FXML
    Button add, orderAdd;

    @FXML
    RadioButton tomato, alfredo;

    @FXML
    CheckBox ExtraCheese, ExtraSauce;


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

    @FXML
    void addTopping() {
        selectedTopping.getItems().add(toppingcombobox.getSelectionModel().getSelectedItem());
        if(selectedTopping.getItems().size() == Constants.maxToppings) {add.setDisable(Constants.disable);}
        if(selectedTopping.getItems().size() >= Constants.minToppings) {orderAdd.setDisable(!Constants.disable);}
        TotalPrice();
    }

    @FXML
    void removeTopping() {
        selectedTopping.getItems().remove(selectedTopping.getSelectionModel().getSelectedIndex());
        if (add.isDisabled()) {add.setDisable(!Constants.disable);}
        else if(selectedTopping.getItems().size() < Constants.minToppings) {orderAdd.setDisable(Constants.disable);}
        TotalPrice();
    }

    @FXML
    void clicked(){TotalPrice();}

    @FXML
    void TotalPrice() {
        Pizza p = makeZa();
        Double price = p.price();
        tf.setText(price.toString());
    }

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
