package config;

public class APIConfig {

    private String apiKeyCurrencyConverter;
    private String apiKeyCurrencyLayer;
    private String apiKeyOpenExchangeRates;

    public String getApiKeyCurrencyConverter() {
        return apiKeyCurrencyConverter;
    }

    public void setApiKeyCurrencyConverter(String apiKeyCurrencyConverter) {
        this.apiKeyCurrencyConverter = apiKeyCurrencyConverter;
    }

    public String getApiKeyCurrencyLayer() {
        return apiKeyCurrencyLayer;
    }

    public void setApiKeyCurrencyLayer(String apiKeyCurrencyLayer) {
        this.apiKeyCurrencyLayer = apiKeyCurrencyLayer;
    }

    public String getApiKeyOpenExchangeRates() {
        return apiKeyOpenExchangeRates;
    }

    public void setApiKeyOpenExchangeRates(String apiKeyOpenExchangeRates) {
        this.apiKeyOpenExchangeRates = apiKeyOpenExchangeRates;
    }
}
