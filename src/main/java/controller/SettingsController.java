package controller;

import config.Config;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import utils.ViewUtil;

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
    private ComboBox<String> cboxTheme;

    private final ObservableList<String> listThemes = FXCollections.observableArrayList();

    // Get the API keys from config
    private void initConfig() {
        try {
            txtKeyCurrencyConverter.setText(Config.getCurrencyConverterKey());
            txtKeyCurrencyLayer.setText(Config.getCurrencyLayerKey());
            txtKeyOpenExchange.setText(Config.getOpenExchangeKey());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Fill the combo box with themes, selecting the theme saved in config.properties as default
    private void initColorBox() {
        listThemes.add("Dark");
        listThemes.add("Light");
        cboxTheme.setItems(listThemes);
        try {
            cboxTheme.getSelectionModel().select(Config.getTheme());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Save current vals to config and return to home view
    public void handleSave() {
        try {
            Config.setCurrencyConverterKey(txtKeyCurrencyConverter.getText());
            Config.setCurrencyLayerKey(txtKeyCurrencyLayer.getText());
            Config.setOpenExchangeRatesKey(txtKeyOpenExchange.getText());
            Config.setTheme(cboxTheme.getSelectionModel().getSelectedItem());
            ViewUtil.changeCSS(cboxTheme.getSelectionModel().getSelectedItem());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        ViewUtil.loadView(ViewUtil.HOME);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initConfig();
        initColorBox();
    }
}
