package controller;

import config.Config;
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

    private void loadConfig() {
        try {
            txtKeyCurrencyConverter.setText(Config.getCurrencyConverterKey());
            txtKeyCurrencyLayer.setText(Config.getCurrencyLayerKey());
            txtKeyOpenExchange.setText(Config.getOpenExchangeKey());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleSave() {
        try {
            Config.setCurrencyConverterKey(txtKeyCurrencyConverter.getText());
            Config.setCurrencyLayerKey(txtKeyCurrencyLayer.getText());
            Config.setOpenExchangeRatesKey(txtKeyOpenExchange.getText());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadConfig();
    }

}
