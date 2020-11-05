package utils;

import controller.MainController;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class ViewUtil {

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

    public static final String DARK_THEME = "/css/theme-dark.css";
    public static final String LIGHT_THEME = "/css/theme-light.css";

    // Store the MainController for nav use calls
    private static MainController mainController;

    public static void setMainController(MainController mainController) {
        ViewUtil.mainController = mainController;
    }

    // Load the view
    public static void loadView(String view) {
        try {
            mainController.setCenter(FXMLLoader.load(ViewUtil.class.getResource(view)));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load the toolbar and sidebar
    public static void loadBars() {
        try {
            mainController.setTop(FXMLLoader.load(ViewUtil.class.getResource(TOOLBAR)));
            mainController.setLeft(FXMLLoader.load(ViewUtil.class.getResource(SIDEBAR)));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Reload the stylesheets when settings are changed
    public static void changeCSS(String style) {
        if (style.equals("Dark")) {
            mainController.setCSS(ViewUtil.class.getResource(DARK_THEME).toExternalForm());
        }

        if (style.equals("Light")) {
          mainController.setCSS(ViewUtil.class.getResource(LIGHT_THEME).toExternalForm());
        }
    }
}
