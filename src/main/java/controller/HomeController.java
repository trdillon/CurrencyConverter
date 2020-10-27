package controller;

import enums.Currency;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
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
    private Button btnCurrencyConverter;

    @FXML
    private Button btnCurrencyLayer;

    @FXML
    private Button btnOpenExchange;

    @FXML
    private ChoiceBox<Currency> cboxFrom;

    @FXML
    private ChoiceBox<Currency> cboxTo;

    @FXML
    public void handleCurrencyConverter() {
        //TODO - implement handleConvert()
    }

    @FXML
    public void handleCurrencyLayer() {
        //TODO - implement handleConvert()
    }

    @FXML
    public void handleOpenExchange() {
        //TODO - implement handleConvert()
    }

    public void setChoiceBoxes() {
        cboxFrom.getItems().setAll(Currency.values());
        cboxTo.getItems().setAll(Currency.values());
        cboxFrom.setConverter(new Currency.CurrencyNameConverter());
        cboxTo.setConverter(new Currency.CurrencyNameConverter());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setChoiceBoxes();
    }
    //TODO - implement flags for imgViews
}
