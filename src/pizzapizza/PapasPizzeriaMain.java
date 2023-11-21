package pizzapizza;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PapasPizzeriaMain extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader =
                new FXMLLoader(PapasPizzeriaMain.class.getResource("PapasPizzeriaView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),750,750);
        primaryStage.setResizable(false);
        primaryStage.setHeight(650);
        primaryStage.setWidth(617);
        primaryStage.setTitle("Papa's Pizzeria");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}