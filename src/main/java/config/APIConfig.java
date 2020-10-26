package config;

public class APIConfig {

    private String apiKeyCurrencyConverter;
    private String apiKeyCurrencyLayer;
    private String apiKeyOpenExchange;

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

    public String getApiKeyOpenExchange() {
        return apiKeyOpenExchange;
    }

    public void setApiKeyOpenExchange(String apiKeyOpenExchange) {
        this.apiKeyOpenExchange = apiKeyOpenExchange;
    }
}
