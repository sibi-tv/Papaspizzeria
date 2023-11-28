package pizzapizza;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Controller class for managing store orders in the Pizza Pizza application.
 *
 * @author Sibi suriyanarayan Tiruchirapalli venketaramani, Rahulraj Rajesh
 */
public class StoreOrdersController implements Initializable {

    @FXML
    private ListView<String> listview;

    @FXML
    private ComboBox<String> combobox;

    @FXML
    private TextField ordertotal;

    @FXML
    private Button cancelorder, export;

    /**
     * Finds the index of an order with a given order number in the provided ArrayList.
     *
     * @param s   The order number to search for.
     * @param arr The ArrayList of orders to search within.
     * @return The index of the order if found, otherwise -1.
     */
    private int find(String s, ArrayList<Order> arr){
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i).getOrderNum() == Integer.parseInt(s)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Initializes the controller, setting up the initial state of the UI elements.
     *
     * @param url            The location used to resolve relative paths for the root object.
     * @param resourceBundle The resources specific to this controller.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(Order o : DataModel.getInstance().getStoredOrder().getOrderList()) {combobox.getItems().add("" + o.getOrderNum());}

        combobox.valueProperty().addListener((observableValue, s, selected) -> {
            if(selected != null || (selected == null && !DataModel.getInstance().getStoredOrder().getOrderList().isEmpty())){
                cancelorder.setDisable(false);
                export.setDisable(false);

                int index;
                if(selected == null){
                    index = 0;
                }else{
                    index = find(selected, DataModel.getInstance().getStoredOrder().getOrderList());
                }
                listview.getItems().clear();
                for(Pizza p : DataModel.getInstance().getStoredOrder().getOrderList().get(index).getPizzaList()){
                    listview.getItems().add(p.toString());
                }

                DecimalFormat df = new DecimalFormat( "#.00");

                Double zaPrice = (double)Constants.none;
                for (Pizza p : DataModel.getInstance().getStoredOrder().getOrderList().get(index).getPizzaList()) {zaPrice += p.price();}
                Double zaTax = Double.valueOf(df.format(DataModel.getInstance().getStoredOrder().getOrderList().get(index).numPizzas() * Constants.tax));
                Double totalZaPrice = Double.valueOf(df.format((zaTax+zaPrice)));

                ordertotal.setText("" + totalZaPrice);
            }
        });
    }

    /**
     * Removes the selected order from the combobox and the data model.
     */
    @FXML
    private void removeOrder(){
        int removeIndex = combobox.getSelectionModel().getSelectedIndex();
        combobox.getItems().remove(removeIndex);
        DataModel.getInstance().getStoredOrder().getOrderList().remove(removeIndex);
        listview.getItems().clear();
        ordertotal.setText("");
        if(combobox.getSelectionModel().getSelectedIndex() != -1){
            for(Pizza p : DataModel.getInstance().getStoredOrder().getOrderList().get(combobox.getSelectionModel().getSelectedIndex()).getPizzaList()){
                listview.getItems().add(p.toString());
            }
            DecimalFormat df = new DecimalFormat( "#.00");
            Double zaPrice = (double)Constants.none;
            for (Pizza p : DataModel.getInstance().getStoredOrder().getOrderList().get(combobox.getSelectionModel().getSelectedIndex()).getPizzaList()) {zaPrice += p.price();}
            Double zaTax = Double.valueOf(df.format(DataModel.getInstance().getStoredOrder().getOrderList().get(combobox.getSelectionModel().getSelectedIndex()).numPizzas() * Constants.tax));
            Double totalZaPrice = Double.valueOf(df.format((zaTax+zaPrice)));
            ordertotal.setText("" + totalZaPrice);
        }else {
            cancelorder.setDisable(true);
            export.setDisable(true);
        }
    }

    /**
     * Exports the store orders to a text file using a FileChooser.
     *
     * @throws IOException If an I/O error occurs while writing to the file.
     */
    @FXML
    private void exportOrders() throws IOException {
        FileChooser fc = new FileChooser();
        fc.setTitle("Open a File to Export Your Store Orders");
        fc.setInitialFileName("order.txt");
        Stage stage = new Stage();
        File file = fc.showSaveDialog(stage);

        if(file != null){ //if exported, then write to file with info and then show the dialog window
            FileWriter fw = new FileWriter(file);

            for(Order o : DataModel.getInstance().getStoredOrder().getOrderList()){
                fw.write("Order #: " + o.getOrderNum() + "\n");
                for(Pizza p : o.getPizzaList()){
                    fw.write(p.toString() + "\n");
                }

                DecimalFormat df = new DecimalFormat( "#.00");
                Double zaPrice = (double)Constants.none;
                for (Pizza p : o.getPizzaList()) {zaPrice += p.price();}
                Double zaTax = Double.valueOf(df.format(o.numPizzas() * Constants.tax));
                fw.write("Order total: $" + df.format(zaTax+zaPrice) + "\n\n");
            }
            fw.close();
        }
    }
}
