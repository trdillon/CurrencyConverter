package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {

    @FXML
    private TextField txtKeyCurrencyConverter;

    @FXML
    private TextField txtKeyCurrencyLayer;

    @FXML
    private TextField txtKeyOpenExchange;

    @FXML
    private ComboBox<String> cboxColor;

    public void handleSave() {
        //TODO - save function
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO - implement init function
    }

}
