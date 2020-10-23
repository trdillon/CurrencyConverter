package controller;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private BorderPane bp;

    @FXML
    private FontAwesomeIconView btnExit;

    public void loadScreen(String screen) throws IOException {
        Parent root;
        root = FXMLLoader.load(getClass().getResource(screen + ".fxml"));
        bp.setCenter(root);
    }

    @FXML
    private void handleHelp() throws IOException {
        loadScreen("Help");
    }

    @FXML
    private void handleSettings() throws IOException {
        loadScreen("Settings");
    }

    @FXML
    private void handleNotify() throws IOException {
        loadScreen("Notify");
    }

    @FXML
    private void handleHome() throws IOException {
        loadScreen("Home");
    }

    @FXML
    private void handleHistory() throws IOException {
        loadScreen("History");
    }

    @FXML
    private void handleFavorites() throws IOException {
        loadScreen("Favorites");
    }

    @FXML
    private void handleData() throws IOException {
        loadScreen("Data");
    }

    @FXML
    private void handleExit() {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }
}
