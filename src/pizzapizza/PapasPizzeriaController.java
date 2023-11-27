package pizzapizza;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * ____
 *
 * @author Sibi suriyanarayan Tiruchirapalli venketaramani, Rahulraj Rajesh
 */
public class PapasPizzeriaController {
    private Order order;

    @FXML
    void specialties() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SpecialtyView.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Specialty Pizza Selection");
        stage.setScene(new Scene(root1));
        stage.show();
    }
    @FXML
    void buildpizza() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BuildPizzaView.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Build Your Own Pizza!");
        stage.setScene(new Scene(root1));
        stage.show();
    }
    @FXML
    void currentorder() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CurrentOrderView.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Current Order");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    void storeorders() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StoreOrdersView.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Store Orders");
        stage.setScene(new Scene(root1));
        stage.show();
    }
}