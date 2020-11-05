package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import utils.ViewUtil;

public class ToolbarController {

    @FXML
    private void handleHelp() {
        ViewUtil.loadView(ViewUtil.HELP);
    }

    @FXML
    private void handleSettings() {
        ViewUtil.loadView(ViewUtil.SETTINGS);
    }

    @FXML
    private void handleExit() {
        Platform.exit();
    }
}
