package utils;

import controller.MainController;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class ViewNavigator {

    // Constants for the different view filenames
    public static final String DATA = "/fxml/DataView.fxml";
    public static final String FAVS = "/fxml/FavoritesView.fxml";
    public static final String HELP = "/fxml/HelpView.fxml";
    public static final String HISTORY = "/fxml/HistoryView.fxml";
    public static final String HOME = "/fxml/HomeView.fxml";
    public static final String MAIN = "/fxml/MainView.fxml";
    public static final String SETTINGS = "/fxml/SettingsView.fxml";
    public static final String SIDEBAR = "/fxml/Sidebar.fxml";
    public static final String TOOLBAR = "/fxml/Toolbar.fxml";

    // Store the MainController for nav use calls
    private static MainController mainController;

    public static void setMainController(MainController mainController) {
        ViewNavigator.mainController = mainController;
    }

    // Load the view
    public static void loadView(String view) {
        try {
            mainController.setCenter(FXMLLoader.load(ViewNavigator.class.getResource(view)));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load the toolbar and sidebar
    public static void loadBars() {
        try {
            mainController.setTop(FXMLLoader.load(ViewNavigator.class.getResource(TOOLBAR)));
            mainController.setLeft(FXMLLoader.load(ViewNavigator.class.getResource(SIDEBAR)));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
