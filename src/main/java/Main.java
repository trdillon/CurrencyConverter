import controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import utils.ViewNavigator;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Currency Converter");
        stage.setScene(createScene(loadMainPane()));
        stage.show();
    }

    // Load the main view with toolbar and sidebar
    private Pane loadMainPane() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        Pane mainPane = loader.load(getClass().getResourceAsStream(ViewNavigator.MAIN));

        MainController mainController = loader.getController();
        ViewNavigator.setMainController(mainController);
        ViewNavigator.loadView(ViewNavigator.HOME);
        ViewNavigator.loadBars();

        return mainPane;
    }

    // Create the main scene and add stylesheet
    private Scene createScene(Pane mainPane) {
        Scene scene = new Scene(mainPane);
        scene.getStylesheets().setAll(getClass().getResource("/css/Styles.css").toExternalForm());

        return scene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
