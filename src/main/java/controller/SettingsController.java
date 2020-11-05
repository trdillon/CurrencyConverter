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
    private ComboBox<String> cboxColor;

    private final ObservableList<String> listThemes = FXCollections.observableArrayList();

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

    private void initColorBox() {
        listThemes.add("Dark");
        listThemes.add("Light");
        cboxColor.setItems(listThemes);
        try {
            cboxColor.getSelectionModel().select(Config.getTheme());
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
            Config.setTheme(cboxColor.getSelectionModel().getSelectedItem());
            ViewUtil.changeCSS(cboxColor.getSelectionModel().getSelectedItem());
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
