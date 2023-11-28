package pizzapizza;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

/**
 * The main class for Papa's Pizzeria application, extending JavaFX Application.
 *
 * @author Sibi suriyanarayan Tiruchirapalli venketaramani, Rahulraj Rajesh
 */
public class PapasPizzeriaMain extends Application {

    /**
     * The entry point for the application, responsible for initializing and displaying the primary stage.
     *
     * @param primaryStage The primary stage of the application.
     * @throws IOException If an error occurs while loading the FXML file.
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader =
                new FXMLLoader(PapasPizzeriaMain.class.getResource("../resources/PapasPizzeriaView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),750,750);
        primaryStage.setResizable(false);
        primaryStage.setHeight(650);
        primaryStage.setWidth(617);
        primaryStage.setTitle("Papa's Pizzeria");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main method, launching the JavaFX application.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        launch();
    }
}