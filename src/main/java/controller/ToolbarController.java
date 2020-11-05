package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import utils.ViewNavigator;

public class ToolbarController {

    @FXML
    private void handleHelp() {
        ViewNavigator.loadView(ViewNavigator.HELP);
    }

    @FXML
    private void handleSettings() {
        ViewNavigator.loadView(ViewNavigator.SETTINGS);
    }

    @FXML
    private void handleExit() {
        Platform.exit();
    }
}
