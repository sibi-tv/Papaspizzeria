package pizzapizza;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Controller class for the main functionality of Papa's Pizzeria application.
 * Handles navigation between different views such as specialty pizza selection,
 * building custom pizzas, viewing the current order, and accessing store orders.
 *
 * @author Sibi suriyanarayan Tiruchirapalli venketaramani, Rahulraj Rajesh
 */
public class PapasPizzeriaController {

    /**
     * Opens the Specialty Pizza Selection view when called.
     *
     * @throws IOException If there is an error loading the FXML file.
     */
    @FXML
    void specialties() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../resources/SpecialtyView.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Specialty Pizza Selection");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Opens the Build Your Own Pizza view when called.
     *
     * @throws IOException If there is an error loading the FXML file.
     */
    @FXML
    void buildpizza() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../resources/BuildPizzaView.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Build Your Own Pizza!");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Opens the Current Order view when called.
     *
     * @throws IOException If there is an error loading the FXML file.
     */
    @FXML
    void currentorder() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../resources/CurrentOrderView.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Current Order");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Opens the Store Orders view when called.
     *
     * @throws IOException If there is an error loading the FXML file.
     */
    @FXML
    void storeorders() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../resources/StoreOrdersView.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Store Orders");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();
    }
}