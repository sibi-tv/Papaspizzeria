package pizzapizza;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class StoreOrdersController implements Initializable {
    @FXML
    ComboBox<String> combobox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        combobox.setItems(FXCollections.observableArrayList("Deluxe", "Supreme", "Meatzza", "Seafood", "Pepperoni"));
    }
}
