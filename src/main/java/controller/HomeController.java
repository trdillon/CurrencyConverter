package controller;

import api.CurrencyConverter;
import api.CurrencyLayer;
import config.Config;
import enums.Currency;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.math.RoundingMode;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private ImageView imgFromFlag;

    @FXML
    private ImageView imgToFlag;

    @FXML
    private Label lblConvertResult;

    @FXML
    private ComboBox<Currency> cboxFrom;

    @FXML
    private ComboBox<Currency> cboxTo;

    @FXML
    public void handleCurrencyConverter() throws IOException {
        CurrencyConverter currencyConverter = new CurrencyConverter();
        Currency fromCurrency = cboxFrom.getSelectionModel().getSelectedItem();
        Currency toCurrency = cboxTo.getSelectionModel().getSelectedItem();
        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        decimalFormat.setRoundingMode(RoundingMode.CEILING);

        if (fromCurrency != null && toCurrency != null) {
            String apiKey = Config.keyCurrencyConverter;
            Double results = currencyConverter.rate(apiKey, fromCurrency, toCurrency);
            String formattedResults = decimalFormat.format(results);
            lblConvertResult.setText(formattedResults);
        }
        else {
            lblConvertResult.setText("Please select two currencies to convert.");
        }
    }

    @FXML
    public void handleCurrencyLayer() throws IOException {
        CurrencyLayer currencyLayer = new CurrencyLayer();
        Currency fromCurrency = cboxFrom.getSelectionModel().getSelectedItem();
        Currency toCurrency = cboxTo.getSelectionModel().getSelectedItem();
        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        decimalFormat.setRoundingMode(RoundingMode.CEILING);

        if (fromCurrency != null && toCurrency != null) {
            String apiKey = Config.keyCurrencyLayer;
            Double results = currencyLayer.rate(apiKey, fromCurrency, toCurrency);
            String formattedResults = decimalFormat.format(results);
            lblConvertResult.setText(formattedResults);
        }
        else {
            lblConvertResult.setText("Please select two currencies to convert.");
        }
    }

    @FXML
    public void handleOpenExchange() {
        //TODO - implement handleConvert()
    }

    public void setComboBoxes() {
        cboxFrom.getItems().setAll(Currency.values());
        cboxTo.getItems().setAll(Currency.values());
        cboxFrom.setConverter(new Currency.CurrencyNameConverter());
        cboxTo.setConverter(new Currency.CurrencyNameConverter());
    }

    public void setImgFromFlag() {
        cboxFrom.valueProperty().addListener((observableValue, oldCurrency, newCurrency) ->
                imgFromFlag.setImage(newCurrency.getCurrencyImage()));
    }

    public void setImgToFlag() {
        cboxTo.valueProperty().addListener((observableValue, oldCurrency, newCurrency) ->
                imgToFlag.setImage(newCurrency.getCurrencyImage()));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setComboBoxes();
        setImgFromFlag();
        setImgToFlag();
    }
}
