package controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

public class MainController {

    @FXML
    private BorderPane mainPane;

    // Center pane handles all views
    public void setCenter(Node node) {
        mainPane.setCenter(node);
    }

    // Top pane for toolbar
    public void setTop(Node node) {
        mainPane.setTop(node);
    }

    // Left pane for sidebar
    public void setLeft(Node node) {
        mainPane.setLeft(node);
    }

    // Set the stylesheets
    public void setCSS(String style) {
        mainPane.getStylesheets().removeAll();
        mainPane.getStylesheets().add(getClass().getResource("/css/Styles.css").toExternalForm());
        mainPane.getStylesheets().add(style);
    }
}
