package config;

import exception.ConverterException;
import exception.ErrorMessages;

public class APIConfigBuilder {

    private final APIConfig config;

    public APIConfigBuilder() {
        config = new APIConfig();
    }

    public APIConfigBuilder buildCurrencyConverter(String apiKey) {
        config.setApiKeyCurrencyConverter(apiKey);

        return this;
    }

    public APIConfigBuilder buildCurrencyLayer(String apiKey) {
        config.setApiKeyCurrencyLayer(apiKey);

        return this;
    }

    public APIConfigBuilder buildOpenExchange(String apiKey) {
        config.setApiKeyOpenExchange(apiKey);

        return this;
    }

    public APIConfig build() {
        if (config.getApiKeyCurrencyConverter() == null &&
            config.getApiKeyCurrencyLayer() == null &&
            config.getApiKeyOpenExchange() == null) {
            throw new ConverterException(ErrorMessages.API_KEY_ERROR);
        }

        return config;
    }
}
