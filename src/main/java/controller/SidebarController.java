package controller;

import javafx.fxml.FXML;
import utils.ViewNavigator;

public class SidebarController {

    @FXML
    private void handleHome() {
        ViewNavigator.loadView(ViewNavigator.HOME);
    }

    @FXML
    private void handleHistory() {
        ViewNavigator.loadView(ViewNavigator.HISTORY);
    }

    @FXML
    private void handleFavorites() {
        ViewNavigator.loadView(ViewNavigator.FAVS);
    }

    @FXML
    private void handleData() {
        ViewNavigator.loadView(ViewNavigator.DATA);
    }
}
