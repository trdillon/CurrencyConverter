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

    //TODO - launch HomeView on app start
    public void loadScreen(String screen) throws IOException {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/fxml/" + screen + ".fxml"));
        bp.setCenter(root);
    }

    @FXML
    private void handleHelp() throws IOException {
        loadScreen("HelpView");
    }

    @FXML
    private void handleSettings() throws IOException {
        loadScreen("SettingsView");
    }

    @FXML
    private void handleNotify() throws IOException {
        loadScreen("NotifyView");
    }

    @FXML
    private void handleHome() throws IOException {
        loadScreen("HomeView");
    }

    @FXML
    private void handleHistory() throws IOException {
        loadScreen("HistoryView");
    }

    @FXML
    private void handleFavorites() throws IOException {
        loadScreen("FavoritesView");
    }

    @FXML
    private void handleData() throws IOException {
        loadScreen("DataView");
    }

    //TODO - save history data on exit for data analysis
    @FXML
    private void handleExit() {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }
}
