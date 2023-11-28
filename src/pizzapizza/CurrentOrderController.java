package pizzapizza;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

/**
 * The CurrentOrderController class is the controller for the current order view in the main application.
 *
 * @author Sibi suriyanarayan Tiruchirapalli venketaramani, Rahulraj Rajesh
 */

public class CurrentOrderController implements Initializable {

    @FXML
    ListView<String> lv;

    @FXML
    TextField orderNum, subTotal, salesTax, totalPrice;

    @FXML
    Button rp, po;

    /**
     * Initializes the controller, setting up the initial state of the UI elements.
     *
     * @param url            The location used to resolve relative paths for the root object.
     * @param resourceBundle The resources specific to this controller.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Integer ordNum = DataModel.getInstance().getOrder().getOrderNum();
        orderNum.setText(ordNum.toString());
        for (Pizza p : DataModel.getInstance().getOrder().getPizzaList()) {lv.getItems().add(p.toString());}
        if(!DataModel.getInstance().getOrder().getPizzaList().isEmpty()){
            rp.setDisable(false);
            po.setDisable(false);
        }
        if(DataModel.getInstance().getOrder() == null || DataModel.getInstance().getOrder().getPizzaList().isEmpty()) {
            Integer i = Constants.none;
            subTotal.setText(i.toString());
            salesTax.setText(i.toString());
            totalPrice.setText(i.toString());
        } else {
            DecimalFormat df = new DecimalFormat("#.00");
            Double[] priceArr = prices();
            subTotal.setText(df.format(priceArr[Constants.none]));
            salesTax.setText(df.format(priceArr[Constants.one]));
            totalPrice.setText(df.format(priceArr[Constants.two]));
        }
        if (lv.getItems().size() == Constants.none) {
            rp.setDisable(Constants.disable);
            po.setDisable(Constants.disable);
        } else {
            rp.setDisable(!Constants.disable);
            po.setDisable(!Constants.disable);
        }
    }

    /**
     * Calculates the prices for the current order and returns an array containing the subtotal, sales tax, and total price.
     *
     * @return An array containing the subtotal, sales tax, and total price of the current order.
     */
    public Double[] prices() {
        Double zaPrice = (double)Constants.none;
        for (Pizza p : DataModel.getInstance().getOrder().getPizzaList()) {zaPrice += p.price();}
        DecimalFormat df = new DecimalFormat( "#.00");
        Double zaTax = Double.valueOf(df.format(DataModel.getInstance().getOrder().numPizzas() * Constants.tax));
        Double totalZaPrice = Double.valueOf(df.format((zaTax+zaPrice)));
        Double[] pricesArr = {zaPrice, zaTax, totalZaPrice};
        return pricesArr;
    }

    /**
     * Removes the selected pizza from the current order, updating the UI elements accordingly.
     */
    @FXML
    void removePizza() { //Order limit?
        int removeIndex = lv.getSelectionModel().getSelectedIndex();
        if(removeIndex > -1){
            lv.getItems().remove(removeIndex);
            DataModel.getInstance().getOrder().getPizzaList().remove(removeIndex);
            if (lv.getItems().size() == Constants.none) {
                rp.setDisable(Constants.disable);
                po.setDisable(Constants.disable);
                Integer i = Constants.none;
                subTotal.setText(i.toString());
                salesTax.setText(i.toString());
                totalPrice.setText(i.toString());
            } else {
                Double[] priceArr = prices();
                subTotal.setText(priceArr[Constants.none].toString());
                salesTax.setText(priceArr[Constants.one].toString());
                totalPrice.setText(priceArr[Constants.two].toString());
            }
        }
    }

    /**
     * Places the current order, adding it to the stored orders and resetting the UI elements for a new order.
     */
    @FXML
    void placeOrder(){
        DataModel.getInstance().getStoredOrder().getOrderList().add(DataModel.getInstance().getOrder());
        DataModel.getInstance().setOrder(new Order());
        lv.getItems().clear();
        subTotal.setText("");
        salesTax.setText("");
        totalPrice.setText("");
        orderNum.setText("");
        rp.setDisable(true);
        po.setDisable(true);
    }

}
