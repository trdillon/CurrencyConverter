package controller;

import enums.Currency;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import service.ConverterService;

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
    private TextField txtAmount;

    @FXML
    private ComboBox<Currency> cboxFrom;

    @FXML
    private ComboBox<Currency> cboxTo;

    // Convert a pair of currencies
    private void pairConvert(String serviceName) {
        ConverterService converterService = new ConverterService();
        Currency fromCurrency = cboxFrom.getSelectionModel().getSelectedItem();
        Currency toCurrency = cboxTo.getSelectionModel().getSelectedItem();

        // Format the result to max 4 digits after the decimal
        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        decimalFormat.setRoundingMode(RoundingMode.CEILING);

        // Make sure we have currencies and amounts
        if (fromCurrency != null && toCurrency != null) {
            if (!txtAmount.getText().isEmpty()) {
                Double results = converterService.rate(serviceName, fromCurrency, toCurrency);
                results *= Double.parseDouble(txtAmount.getText());
                String formattedResults = decimalFormat.format(results);
                lblConvertResult.setText(formattedResults);
            }
            else {
                lblConvertResult.setText("Please enter an amount to convert.");
            }
        }
        else {
            lblConvertResult.setText("Please select two currencies to convert.");
        }
        lblConvertResult.setVisible(true);
    }

    public void handleCurrencyConverter() {
        pairConvert("CurrencyConverter");
    }

    public void handleCurrencyLayer() {
        pairConvert("CurrencyLayer");
    }

    // Populate the combo boxes with Currency enums and convert to Strings
    private void initComboBoxes() {
        cboxFrom.getItems().setAll(Currency.values());
        cboxTo.getItems().setAll(Currency.values());
        cboxFrom.setConverter(new Currency.CurrencyNameConverter());
        cboxTo.setConverter(new Currency.CurrencyNameConverter());
    }

    // Listeners to change flags based on currency selections
    private void initImgFromFlag() {
        cboxFrom.valueProperty().addListener((observableValue, oldCurrency, newCurrency) ->
                imgFromFlag.setImage(newCurrency.getCurrencyImage()));
    }

    private void initImgToFlag() {
        cboxTo.valueProperty().addListener((observableValue, oldCurrency, newCurrency) ->
                imgToFlag.setImage(newCurrency.getCurrencyImage()));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initComboBoxes();
        initImgFromFlag();
        initImgToFlag();
    }
}
