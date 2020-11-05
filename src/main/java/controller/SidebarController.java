package controller;

import javafx.fxml.FXML;
import utils.ViewUtil;

public class SidebarController {

    // Sidebar button handlers
    @FXML
    private void handleHome() {
        ViewUtil.loadView(ViewUtil.HOME);
    }

    @FXML
    private void handleHistory() {
        ViewUtil.loadView(ViewUtil.HISTORY);
    }

    @FXML
    private void handleFavorites() {
        ViewUtil.loadView(ViewUtil.FAVS);
    }

    @FXML
    private void handleData() {
        ViewUtil.loadView(ViewUtil.DATA);
    }
}
