package pizzapizza;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class  StoreOrdersController implements Initializable {

    @FXML
    ListView<String> listview;

    @FXML
    ComboBox<String> combobox;

    @FXML
    TextField ordertotal;

    @FXML
    Button cancelorder, export;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(Order o : DataModel.getInstance().getStoredOrder().getOrderList()) {combobox.getItems().add("" + o.getOrderNum());}

        if(!DataModel.getInstance().getStoredOrder().getOrderList().isEmpty()){
            cancelorder.setDisable(false);
            export.setDisable(false);
        }

        combobox.valueProperty().addListener((observableValue, s, selected) -> {
            listview.getItems().clear();
            for(Pizza p : DataModel.getInstance().getStoredOrder().getOrderList().get(Integer.parseInt(selected)).getPizzaList()){
                listview.getItems().add(p.toString());
            }

            DecimalFormat df = new DecimalFormat( "#.##");

            Double zaPrice = (double)Constants.none;
            for (Pizza p : DataModel.getInstance().getStoredOrder().getOrderList().get(Integer.parseInt(selected)).getPizzaList()) {zaPrice += p.price();}
            Double zaTax = Double.valueOf(df.format(DataModel.getInstance().getStoredOrder().getOrderList().get(Integer.parseInt(selected)).numPizzas() * Constants.tax));
            Double totalZaPrice = Double.valueOf(df.format((zaTax+zaPrice)));

            ordertotal.setText("" + totalZaPrice);
        });
    }

    @FXML
    private void removeOrder(){
        int removeIndex = combobox.getSelectionModel().getSelectedIndex();
        combobox.getItems().remove(removeIndex);
        DataModel.getInstance().getStoredOrder().getOrderList().remove(removeIndex);

        if(listview.getItems().isEmpty()){
            cancelorder.setDisable(true);
            export.setDisable(true);
        }
    }

    @FXML
    private void exportOrders() throws IOException {
        FileChooser fc = new FileChooser();
        fc.setTitle("Open a File to Export Your Store Orders");
        fc.setInitialFileName("order.txt");
        Stage stage = new Stage();
        File file = fc.showSaveDialog(stage);

        FileWriter fw = new FileWriter(file);

        for(Order o : DataModel.getInstance().getStoredOrder().getOrderList()){
            fw.write("Order #: " + o.getOrderNum() + "\n");
            for(Pizza p : o.getPizzaList()){
                fw.write(p.toString() + "\n");
            }

            DecimalFormat df = new DecimalFormat( "#.##");
            Double zaPrice = (double)Constants.none;
            for (Pizza p : o.getPizzaList()) {zaPrice += p.price();}
            Double zaTax = Double.valueOf(df.format(o.numPizzas() * Constants.tax));
            fw.write("Order total: $" + df.format(zaTax+zaPrice) + "\n\n");
        }
        fw.close();

        if(file.exists()){ //if exported, then write to file with info and then show the dialog window

        }
    }
}
