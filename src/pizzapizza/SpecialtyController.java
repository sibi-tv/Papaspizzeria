package pizzapizza;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class SpecialtyController implements Initializable {
    @FXML
    ComboBox<String> combobox;

    @FXML
    TextField totalprice;

    @FXML
    CheckBox extracheese, extrasauce;

    @FXML
    ListView<String> toppingslist;

    @FXML
    ImageView deluxe, supreme, meatzza, seafood, pepperoni;

    @FXML
    RadioButton small, medium, large;

    @FXML
    Button addtoorder;

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

    private String getSize(){
        if(small.isSelected()){
            return "small";
        }else if(medium.isSelected()){
            return "medium";
        }
        return "large";
    }

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
        DecimalFormat df = new DecimalFormat("#.##");
        totalprice.setText("$" + df.format(price));
    }

    @FXML
    private void check1(){
        double price;
        if(extracheese.isSelected()){
            price = Double.parseDouble(totalprice.getText().substring(Constants.one)) + Constants.one;
        }else{
            price = Double.parseDouble(totalprice.getText().substring(Constants.one)) - Constants.one;
        }
        DecimalFormat df = new DecimalFormat("#.##");
        totalprice.setText("$" + df.format(price));
    }

    @FXML
    private void check2(){
        double price;
        if(extrasauce.isSelected()){
            price = Double.parseDouble(totalprice.getText().substring(Constants.one)) + Constants.one;
        }else{
            price = Double.parseDouble(totalprice.getText().substring(Constants.one)) - Constants.one;
        }
        DecimalFormat df = new DecimalFormat("#.##");
        totalprice.setText("$" + df.format(price));
    }

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
