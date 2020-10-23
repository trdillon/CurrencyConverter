package controller;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private FontAwesomeIconView btnExit;

    @FXML
    private FontAwesomeIconView btnHelp;

    @FXML
    private FontAwesomeIconView btnSettings;

    @FXML
    private FontAwesomeIconView btnNotify;

    @FXML
    private FontAwesomeIconView btnHome;

    @FXML
    private FontAwesomeIconView btnHistory;

    @FXML
    private FontAwesomeIconView btnFavorites;

    @FXML
    private FontAwesomeIconView btnData;

    @FXML
    private void goHelp() {
        //TODO - help screen
    }

    @FXML
    private void goSettings() {
        //TODO - settings screen
    }

    @FXML
    private void goNotify() {
        //TODO - notification screen
    }

    @FXML
    private void goHome() {
        //TODO - home screen
    }

    @FXML
    private void goHistory() {
        //TODO - history screen
    }

    @FXML
    private void goFavorites() {
        //TODO - favorites screen
    }

    @FXML
    private void goData() {
        //TODO - data screen
    }

    @FXML
    private void exitApp() {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }
}
