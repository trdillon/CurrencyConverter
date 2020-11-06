package controller;

import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HelpController {

    @FXML
    private AnchorPane ap;

    private Stage stage;

    // Access hostServices from the current stage to use showDocument
    private void openURL(String url) {
        HostServices hostServices = (HostServices)this.getStage().getProperties().get("hostServices");
        hostServices.showDocument(url);
    }

    private Stage getStage() {
        if(this.stage==null)
            this.stage = (Stage) this.ap.getScene().getWindow();
        return stage;
    }

    public void handleGithub() {
        openURL("http://github.com/trdillon/CurrencyConverter");
    }

    public void handleCurrencyConverter() {
        openURL("https://free.currencyconverterapi.com/");
    }

    public void handleCurrencyLayer() {
        openURL("https://currencylayer.com/");
    }

    public void handleOpenExchangeRates() {
        openURL("https://openexchangerates.org/");
    }
}
