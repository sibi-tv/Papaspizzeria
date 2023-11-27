package pizzapizza;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class SpecialtyController implements Initializable {
    @FXML
    ComboBox<String> combobox;

    @FXML
    Label totalprice;

    @FXML
    CheckBox extraextra;

    @FXML
    ListView toppingslist;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //combobox.setItems(FXCollections.observableArrayList("Deluxe", "Supreme", "Meatzza", "Seafood", "Pepperoni"));
    }
}
