package controller;

import enums.Currency;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.net.URL;
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
    public void handleCurrencyConverter() {
        //TODO - implement handleConvert()
    }

    @FXML
    public void handleCurrencyLayer() {

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
